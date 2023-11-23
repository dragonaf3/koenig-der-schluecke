package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;

public class Einstellungen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einstellungen);

        //Erstellung der Elemente der Activity
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueEinstellungenSeite);
        ImageButton zumFeedbackButton = findViewById(R.id.imageButtonFeedback);

        //Definieren der OnClickListener
        zurueckZumHauptmenueButton.setOnClickListener(v -> startActivity(new Intent(this, Startbildschirm.class)));
        zumFeedbackButton.setOnClickListener(v -> startActivity(new Intent(this, Feedback.class)));
    }
}
