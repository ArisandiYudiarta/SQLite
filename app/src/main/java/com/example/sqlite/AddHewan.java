package com.example.sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddHewan extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST  = 100;
    Uri imageFilePath;
    EditText nama, breed, jk, umur, img;
    ImageView imageView;
    Button inputImg, save;
    Bitmap imageToStore;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hewan);

        imageView = (ImageView) findViewById(R.id.imageView);

        nama = findViewById(R.id.inputNama);
        breed = findViewById(R.id.inputBreed);
        jk = findViewById(R.id.inputGender);
        umur = findViewById(R.id.inputAge);
        try {
            img = findViewById(R.id.inputLinkIMG);
            imageView = findViewById(R.id.imageView);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

//        berat = findViewById(R.id.inputWeight);
//        tinggi = findViewById(R.id.inputHeight);
//        story = findViewById(R.id.inputStory);

        save = findViewById(R.id.btnSimpan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper dbhewan = new MyDatabaseHelper(AddHewan.this);
                dbhewan.addHewan(nama.getText().toString().trim(),
                        breed.getText().toString().trim(),
                        jk.getText().toString().trim(),
                        Integer.valueOf(umur.getText().toString().trim()),
                        img.getText().toString().trim());
            }
        });
    }
    public void chooseImage(View objectView){
        try{
            Intent objectIntent = new Intent();
            objectIntent.setType ("image/*");

            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent, PICK_IMAGE_REQUEST);


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);

                imageView.setImageBitmap(imageToStore);
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}