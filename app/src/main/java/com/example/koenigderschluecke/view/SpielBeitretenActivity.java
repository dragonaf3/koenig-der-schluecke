package com.example.koenigderschluecke.view;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.network.BluetoothConnector;
import com.example.koenigderschluecke.network.BluetoothConnectorImpl;

import java.util.Set;

//TODO: Controller Auslagerung
public class SpielBeitretenActivity extends AppCompatActivity {

//    @RequiresApi(api = Build.VERSION_CODES.S)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spiel_beitreten);
//
//        BluetoothConnector bluetoothConnector = new BluetoothConnectorImpl(this);
//        bluetoothConnector.bluetoothAktivierung();
//
//        // Broadcast
//        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        registerReceiver(receiver, filter);
//
//        displayBluetoothDevices(bluetoothConnector.getBluetoothDevices());
//
//        Button zurueckZumHauptmenueSpielBeitretenButton = findViewById(R.id.zurueckZumHauptmenueSpielBeitretenButton);
//
//        zurueckZumHauptmenueSpielBeitretenButton.setOnClickListener(v -> {
//            Intent intent = new Intent(this, StartbildschirmActivity.class);
//            startActivity(intent);
//        });
//    }

    @SuppressLint("MissingPermission") //Wurde gecheckt
    private void displayBluetoothDevices(Set<BluetoothDevice> devices) {
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        linearLayout.removeAllViews(); // Entfernt vorherige Views

        for (BluetoothDevice device : devices) {
            TextView textView = new TextView(this);
            textView.setText(device.getName());
            linearLayout.addView(textView);
        }
    }

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                @SuppressLint("MissingPermission") String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

}