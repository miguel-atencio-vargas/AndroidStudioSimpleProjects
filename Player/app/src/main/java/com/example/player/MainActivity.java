package com.example.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToMusic(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void goToVideo(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}