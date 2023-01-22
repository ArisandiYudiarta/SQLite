package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
    private static final String COLUMN_AGE = "age";
//    private static final String COLUMN_WEIGHT = "berat";
//    private static final String COLUMN_HEIGHT = "tinggi";
//    private static final String COLUMN_STORY = "pet_story";

    private static final String TABLE_NAME2 = "history_adopsi";

    private static final String COLUMN_ID2 = "id_hewan";
    private static final String COLUMN_NAME2 = "nama_hewan";
    private static final String COLUMN_BREED2 = "breed";
    private static final String COLUMN_GENDER2 = "jk";
    private static final String COLUMN_AGE2 = "age";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_BREED + " TEXT, " +
                        COLUMN_GENDER + " TEXT, " +
                        COLUMN_AGE + " INTEGER);";

        String query2 = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_BREED + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_AGE + " INTEGER);";

        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    void addHewan(String nama, String breed, String jk, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, nama);
        cv.put(COLUMN_BREED, breed);
        cv.put(COLUMN_GENDER, jk);
        cv.put(COLUMN_AGE, age);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Initial Insert Fails.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfuly.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db. rawQuery(query, null);
        }
        return cursor;
    }
}
