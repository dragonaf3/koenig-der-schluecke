package com.example.koenigderschluecke.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.koenigderschluecke.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Erstellung der Elemente der Activity
        Button zurueckZumHauptmenueButton = findViewById(R.id.buttonZurueckZumHauptmenueFeedbackSeite);

        TextInputEditText editText = findViewById(R.id.feedbackInputText);
        Button sendEmailButton = findViewById(R.id.buttonFeedbackAbsenden);

        //Definieren der OnClickListener
        sendEmailButton.setOnClickListener(view -> {
            String text = Objects.requireNonNull(editText.getText()).toString();
            sendEmail(text);
        });

        zurueckZumHauptmenueButton.setOnClickListener(v -> startActivity(new Intent(this, StartbildschirmActivity.class)));

    }

    //Könnte theoretisch in einem separaten Controller, aber da das Projekt ziemlich klein ist, bleibt es hier.
    private void sendEmail(String text) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"evaapple@outlook.de"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "User Feedback zu König der Schlücke");
        emailIntent.putExtra(Intent.EXTRA_TEXT, text);

        try {
            startActivity(Intent.createChooser(emailIntent, "Wählen Sie eine E-Mail-App aus..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FeedbackActivity.this, "Es sind keine E-Mail-Clients installiert.", Toast.LENGTH_SHORT).show();
        }
    }
}
