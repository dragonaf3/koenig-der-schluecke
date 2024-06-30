package com.example.koenigderschluecke.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RuleDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rules.db";
    private static final int DATABASE_VERSION = 2; // Update version

    // Regelset Tabelle
    private static final String TABLE_RULESET = "ruleset";
    private static final String COLUMN_RULESET_ID = "id";
    private static final String COLUMN_RULESET_NAME = "name";

    // Regel Tabelle
    private static final String TABLE_RULE = "rule";
    private static final String COLUMN_RULE_ID = "id";
    private static final String COLUMN_RULE_DESCRIPTION = "description";
    private static final String COLUMN_RULE_RULESET_ID = "ruleset_id";
    private static final String COLUMN_RULE_CARD = "card"; // New column

    private static final String CREATE_TABLE_RULESET =
            "CREATE TABLE " + TABLE_RULESET + "("
                    + COLUMN_RULESET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_RULESET_NAME + " TEXT"
                    + ")";

    private static final String CREATE_TABLE_RULE =
            "CREATE TABLE " + TABLE_RULE + "("
                    + COLUMN_RULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_RULE_DESCRIPTION + " TEXT,"
                    + COLUMN_RULE_RULESET_ID + " INTEGER,"
                    + COLUMN_RULE_CARD + " TEXT," // New column
                    + "FOREIGN KEY(" + COLUMN_RULE_RULESET_ID + ") REFERENCES "
                    + TABLE_RULESET + "(" + COLUMN_RULESET_ID + ")"
                    + ")";

    public RuleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RULESET);
        db.execSQL(CREATE_TABLE_RULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + TABLE_RULE + " ADD COLUMN " + COLUMN_RULE_CARD + " TEXT");
        }
    }
}
