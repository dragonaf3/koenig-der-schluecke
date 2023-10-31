package com.example.koenigderschluecke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Statistik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistik);

        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueStatistikSeite);

        zurueckZumHauptmenueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onZurueckZumHauptmenue(v);
            }
        });
    }

    private void onZurueckZumHauptmenue(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
