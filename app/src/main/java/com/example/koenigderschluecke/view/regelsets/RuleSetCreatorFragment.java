package com.example.koenigderschluecke.view.regelsets;

import static java.security.AccessController.getContext;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.koenigderschluecke.R;
import com.example.koenigderschluecke.db.RuleDatabaseHelper;

public class RuleSetCreatorFragment extends Fragment {
    private static final String ARG_RULE_SET_ID = "rule_set_id";

    private RuleDatabaseHelper dbHelper;
    private EditText editTextRuleSetName;
    private EditText[] editTextRuleCards;
    private long ruleSetId = -1;

    public static RuleSetCreatorFragment newInstance(long ruleSetId) {
        RuleSetCreatorFragment fragment = new RuleSetCreatorFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_RULE_SET_ID, ruleSetId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rule_set_creator, container, false);

        dbHelper = new RuleDatabaseHelper(getContext());
        editTextRuleSetName = view.findViewById(R.id.editTextRuleSetName);
        editTextRuleCards = new EditText[]{
                view.findViewById(R.id.editTextRuleCard1),
                view.findViewById(R.id.editTextRuleCard2),
                view.findViewById(R.id.editTextRuleCard3),
                view.findViewById(R.id.editTextRuleCard4),
                view.findViewById(R.id.editTextRuleCard5),
                view.findViewById(R.id.editTextRuleCard6),
                view.findViewById(R.id.editTextRuleCard7),
                view.findViewById(R.id.editTextRuleCard8),
                view.findViewById(R.id.editTextRuleCard9),
                view.findViewById(R.id.editTextRuleCard10),
                view.findViewById(R.id.editTextRuleCardJack),
                view.findViewById(R.id.editTextRuleCardQueen),
                view.findViewById(R.id.editTextRuleCardKing),
                view.findViewById(R.id.editTextRuleCardAce)
        };

        if (getArguments() != null) {
            ruleSetId = getArguments().getLong(ARG_RULE_SET_ID, -1);
            if (ruleSetId != -1) {
                loadRuleSet(ruleSetId);
            }
        }

        view.findViewById(R.id.buttonSaveRuleSet).setOnClickListener(v -> saveRuleSet());

        return view;
    }

    private void loadRuleSet(long ruleSetId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("ruleset", new String[]{"name"}, "id = ?", new String[]{String.valueOf(ruleSetId)}, null, null, null);
        if (cursor.moveToFirst()) {
            editTextRuleSetName.setText(cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();

        cursor = db.query("card_rule", new String[]{"card", "description"}, "ruleset_id = ?", new String[]{String.valueOf(ruleSetId)}, null, null, null);
        while (cursor.moveToNext()) {
            String card = cursor.getString(cursor.getColumnIndex("card"));
            String description = cursor.getString(cursor.getColumnIndex("description"));
            int index = getCardIndex(card);
            if (index != -1) {
                editTextRuleCards[index].setText(description);
            }
        }
        cursor.close();
    }

    private int getCardIndex(String card) {
        switch (card) {
            case "Eins":
                return 0;
            case "Zwei":
                return 1;
            case "Drei":
                return 2;
            case "Vier":
                return 3;
            case "Fünf":
                return 4;
            case "Sechs":
                return 5;
            case "Sieben":
                return 6;
            case "Acht":
                return 7;
            case "Neun":
                return 8;
            case "Zehn":
                return 9;
            case "Bube":
                return 10;
            case "Dame":
                return 11;
            case "König":
                return 12;
            case "Ass":
                return 13;
            default:
                return -1;
        }
    }

    private void saveRuleSet() {
        String ruleSetName = editTextRuleSetName.getText().toString().trim();
        if (ruleSetName.isEmpty()) {
            Toast.makeText(getContext(), "Please enter a rule set name", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues ruleSetValues = new ContentValues();
        ruleSetValues.put("name", ruleSetName);

        if (ruleSetId == -1) {
            ruleSetId = db.insert("ruleset", null, ruleSetValues);
        } else {
            db.update("ruleset", ruleSetValues, "id = ?", new String[]{String.valueOf(ruleSetId)});
            db.delete("card_rule", "ruleset_id = ?", new String[]{String.valueOf(ruleSetId)});
        }

        if (ruleSetId == -1) {
            Toast.makeText(getContext(), "Failed to save rule set", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] cardNames = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Bube", "Dame", "König", "Ass"};

        for (int i = 0; i < editTextRuleCards.length; i++) {
            String ruleDescription = editTextRuleCards[i].getText().toString().trim();
            if (!ruleDescription.isEmpty()) {
                ContentValues cardRuleValues = new ContentValues();
                cardRuleValues.put("card", cardNames[i]);
                cardRuleValues.put("description", ruleDescription);
                cardRuleValues.put("ruleset_id", ruleSetId);
                db.insert("card_rule", null, cardRuleValues);
            }
        }

        Toast.makeText(getContext(), "Rule set saved successfully", Toast.LENGTH_SHORT).show();
        getFragmentManager().popBackStack();
    }
}

