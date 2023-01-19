package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Petshop.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "hewan_adopsi";

    private static final String COLUMN_ID = "id_hewan";
    private static final String COLUMN_NAME = "nama_hewan";
    private static final String COLUMN_BREED = "breed";
    private static final String COLUMN_GENDER = "jk";
    private static final String COLUMN_AGE = "umur";
    private static final String COLUMN_WEIGHT = "berat";
    private static final String COLUMN_HEIGHT = "tinggi";
    private static final String COLUMN_STORY = "pet_story";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_BREED + "TEXT, " +
                        COLUMN_GENDER + "TEXT, " +
                        COLUMN_AGE + "INTEGER, " +
                        COLUMN_WEIGHT + "INTEGER, " +
                        COLUMN_HEIGHT + "INTEGER, " +
                        COLUMN_STORY + "TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addHewan(String nama, String breed, String jk, int umur,int berat, int tinggi, String story){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, nama);
        cv.put(COLUMN_BREED, breed);
        cv.put(COLUMN_GENDER, jk);
        cv.put(COLUMN_AGE, umur);
        cv.put(COLUMN_WEIGHT, berat);
        cv.put(COLUMN_HEIGHT, tinggi);
        cv.put(COLUMN_STORY, story);
    }
}
