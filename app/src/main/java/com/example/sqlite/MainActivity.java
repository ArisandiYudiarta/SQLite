package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> id_hewan, nama_hewan, breed, jenis_kelamin, umur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.addBtn);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddHewan.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        id_hewan = new ArrayList<>();
        nama_hewan = new ArrayList<>();
        breed = new ArrayList<>();
        jenis_kelamin = new ArrayList<>();
        umur = new ArrayList<>();

        storeDatainArrays();
    }

    void storeDatainArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "There is no data available", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                id_hewan.add(cursor.getString(0));
                nama_hewan.add(cursor.getString(1));
                breed.add(cursor.getString(2));
                jenis_kelamin.add(cursor.getString(3));
                umur.add(cursor.getString(4));
            }
        }
    }
}