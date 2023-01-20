package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddHewan extends AppCompatActivity {

    EditText nama, breed, jk, umur, berat, tinggi, story;
    Button clear, save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hewan);

        nama = findViewById(R.id.inputNama);
        breed = findViewById(R.id.inputBreed);
        jk = findViewById(R.id.inputGender);
        umur = findViewById(R.id.inputAge);
        berat = findViewById(R.id.inputWeight);
        tinggi = findViewById(R.id.inputHeight);
        story = findViewById(R.id.inputStory);


    }
}