package com.example.aplicacionparalau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    TextView descriptionOutput, likesOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.wImageSelected);
        descriptionOutput = findViewById(R.id.wDescrip);
        likesOutput = findViewById(R.id.wLikesP);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Bitmap image = bundle.getParcelable("image");
            imageView.setImageBitmap(image);
            descriptionOutput.setText(bundle.getString("description"));
            likesOutput.setText(bundle.getString("likes"));
        }
    }
}