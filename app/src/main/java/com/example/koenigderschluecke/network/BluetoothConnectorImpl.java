package com.example.koenigderschluecke.network;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Set;
import java.util.UUID;

//TODO: Strings extrahieren

/**
 * Diese Klasse implementiert das Interface BluetoothConnector.
 */
@RequiresApi(api = Build.VERSION_CODES.S)
public class BluetoothConnectorImpl implements BluetoothConnector {
    public static final UUID MY_UUID = UUID.randomUUID();
    private final static int REQUEST_ENABLE_BT = 1;
    private final BluetoothManager bluetoothManager;
    private final BluetoothAdapter bluetoothAdapter;
    private Context context;
    private Set<BluetoothDevice> pairedDevices;

    public BluetoothConnectorImpl(Context context) {
        this.context = context;
        this.bluetoothManager = context.getSystemService(BluetoothManager.class);
        this.bluetoothAdapter = bluetoothManager.getAdapter();

        this.pairedDevices = holePairedDevices();
    }

    @SuppressLint("MissingPermission") //PermissionCheck ist separate Methode
    @Override
    public void bluetoothAktivierung() {
        if (!checkBluetoothSupport()) {
            Toast.makeText(context, "Bluetooth wird nicht unterstützt", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!checkBluetoothEnabled()) {
            permissionCheckBLUETOOTH_CONNECT();
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                System.err.println("Fehler");
            }
        }
        Toast.makeText(context, "Bluetooth bereits aktiviert", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Set<BluetoothDevice> getBluetoothDevices() {
        return pairedDevices;
    }

    private boolean checkBluetoothSupport() {
        return bluetoothAdapter != null;
    }

    private boolean checkBluetoothEnabled() {
        return bluetoothAdapter.isEnabled();
    }

    @SuppressLint("MissingPermission") //PermissionCheck ist separate Methode
    private Set<BluetoothDevice> holePairedDevices() {
        permissionCheckBLUETOOTH_CONNECT();
        return bluetoothAdapter.getBondedDevices();
    }

    private void permissionCheckBLUETOOTH_CONNECT() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 2);
            ((Activity) context).finish();
            context.startActivity(((Activity) context).getIntent());
        }
    }
}