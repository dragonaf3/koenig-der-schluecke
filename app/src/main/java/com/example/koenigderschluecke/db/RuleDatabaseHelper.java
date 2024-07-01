package com.example.koenigderschluecke.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RuleDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rules.db";
    private static final int DATABASE_VERSION = 2; // Update version if needed

    // Regelset Tabelle
    private static final String TABLE_RULESET = "ruleset";
    private static final String COLUMN_RULESET_ID = "id";
    private static final String COLUMN_RULESET_NAME = "name";

    // Kartenregel Tabelle
    private static final String TABLE_CARD_RULE = "card_rule";
    private static final String COLUMN_CARD_RULE_ID = "id";
    private static final String COLUMN_CARD_RULE_CARD = "card";
    private static final String COLUMN_CARD_RULE_DESCRIPTION = "description";
    private static final String COLUMN_CARD_RULE_RULESET_ID = "ruleset_id";

    private static final String CREATE_TABLE_RULESET =
            "CREATE TABLE " + TABLE_RULESET + "("
                    + COLUMN_RULESET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_RULESET_NAME + " TEXT"
                    + ")";

    private static final String CREATE_TABLE_CARD_RULE =
            "CREATE TABLE " + TABLE_CARD_RULE + "("
                    + COLUMN_CARD_RULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_CARD_RULE_CARD + " TEXT,"
                    + COLUMN_CARD_RULE_DESCRIPTION + " TEXT,"
                    + COLUMN_CARD_RULE_RULESET_ID + " INTEGER,"
                    + "FOREIGN KEY(" + COLUMN_CARD_RULE_RULESET_ID + ") REFERENCES "
                    + TABLE_RULESET + "(" + COLUMN_RULESET_ID + ")"
                    + ")";

    public RuleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RULESET);
        db.execSQL(CREATE_TABLE_CARD_RULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL(CREATE_TABLE_CARD_RULE);
        }
    }
}
