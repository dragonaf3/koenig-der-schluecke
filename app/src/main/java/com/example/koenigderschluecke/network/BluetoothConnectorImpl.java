package com.example.koenigderschluecke.network;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BluetoothConnectorImpl implements BluetoothConnector {
    private static final String TAG = "BluetoothConnectorImpl";
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;
    private BluetoothDevice connectedDevice;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<String> discoveredDevices;
    private BluetoothEventListener bluetoothEventListener;

    public BluetoothConnectorImpl() {
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.discoveredDevices = new ArrayList<>();
    }

    @Override
    public void initialize() throws IOException {
        if (bluetoothAdapter == null) {
            throw new IOException("Bluetooth is not supported on this device.");
        }
        if (!bluetoothAdapter.isEnabled()) {
            throw new IOException("Bluetooth is not enabled.");
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void startDiscovery() throws IOException {
        if (!bluetoothAdapter.startDiscovery()) {
            throw new IOException("Failed to start device discovery.");
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void stopDiscovery() throws IOException {
        if (!bluetoothAdapter.cancelDiscovery()) {
            throw new IOException("Failed to stop device discovery.");
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void connect(String macAddress) throws IOException {
        bluetoothAdapter.cancelDiscovery();
        connectedDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        bluetoothSocket = connectedDevice.createRfcommSocketToServiceRecord(MY_UUID);

        try {
            bluetoothSocket.connect();
            inputStream = bluetoothSocket.getInputStream();
            outputStream = bluetoothSocket.getOutputStream();
            if (bluetoothEventListener != null) {
                bluetoothEventListener.onConnected();
            }
        } catch (IOException e) {
            try {
                bluetoothSocket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }
            throw new IOException("Failed to connect to the device.", e);
        }
    }

    @Override
    public void disconnect() throws IOException {
        try {
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
            if (bluetoothEventListener != null) {
                bluetoothEventListener.onDisconnected();
            }
        } catch (IOException e) {
            throw new IOException("Failed to disconnect from the device.", e);
        }
    }

    @Override
    public void sendData(byte[] data) throws IOException {
        if (outputStream == null) {
            throw new IOException("Output stream is not initialized.");
        }
        try {
            outputStream.write(data);
        } catch (IOException e) {
            throw new IOException("Failed to send data.", e);
        }
    }

    @Override
    public byte[] receiveData() throws IOException {
        if (inputStream == null) {
            throw new IOException("Input stream is not initialized.");
        }
        byte[] buffer = new byte[1024];
        int bytes;
        try {
            bytes = inputStream.read(buffer);
            byte[] result = new byte[bytes];
            System.arraycopy(buffer, 0, result, 0, bytes);
            if (bluetoothEventListener != null) {
                bluetoothEventListener.onDataReceived(result);
            }
            return result;
        } catch (IOException e) {
            throw new IOException("Failed to receive data.", e);
        }
    }

    @Override
    public List<String> getDiscoveredDevices() {
        return discoveredDevices;
    }

    @Override
    public void setBluetoothEventListener(BluetoothEventListener listener) {
        this.bluetoothEventListener = listener;
    }
}
