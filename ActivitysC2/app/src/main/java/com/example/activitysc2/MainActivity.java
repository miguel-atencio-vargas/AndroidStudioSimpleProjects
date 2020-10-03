package com.example.activitysc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToRegister(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void goToConsult(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("PARAM1", "Miguel");
        startActivity(intent);
    }
}