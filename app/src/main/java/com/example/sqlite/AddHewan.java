package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddHewan extends AppCompatActivity {

    EditText nama, breed, jk, age, berat, tinggi, story;
    Button clear, save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hewan);

        nama = findViewById(R.id.inputNama);
        breed = findViewById(R.id.inputBreed);
        jk = findViewById(R.id.inputGender);
        age = findViewById(R.id.inputAge);
        save = findViewById(R.id.btnSimpan);
//        berat = findViewById(R.id.inputWeight);
//        tinggi = findViewById(R.id.inputHeight);
//        story = findViewById(R.id.inputStory);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddHewan.this);
                myDB.addHewan(nama.getText().toString().trim(),
                        breed.getText().toString().trim(),
                        jk.getText().toString().trim(),
                        Integer.parseInt(age.getText().toString().trim()));
            }
        });
    }
}