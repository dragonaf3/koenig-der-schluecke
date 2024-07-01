package com.example.koenigderschluecke.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;

/**
 * Diese Klasse repräsentiert die EinstellungenActivity.
 * Sie erbt von der AppCompatActivity-Klasse.
 */
public class EinstellungenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        //Erstellung der Elemente der Activity
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueSpielendeFragmentSeite);
        ImageButton zumFeedbackButton = findViewById(R.id.imageButtonFeedback);

        //Definieren der OnClickListener
        zurueckZumHauptmenueButton.setOnClickListener(v -> startActivity(new Intent(this, StartbildschirmActivity.class)));
        zumFeedbackButton.setOnClickListener(v -> startActivity(new Intent(this, FeedbackActivity.class)));
    }
}
