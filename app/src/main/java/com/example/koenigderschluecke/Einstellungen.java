package com.example.koenigderschluecke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Einstellungen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einstellungen);

        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueEinstellungenSeite);
        ImageButton zumFeedbackButton = findViewById(R.id.imageButtonFeedback);

        zurueckZumHauptmenueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onZurueckZumHauptmenue(v);
            }
        });

        zumFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onZumFeedback(v);
            }
        });
    }

    private void onZurueckZumHauptmenue(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void onZumFeedback(View view) {
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }
}
