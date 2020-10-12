package com.example.diasdelmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView numeroImpares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        numeroImpares = findViewById(R.id.wNumbers);
        for(int i = 1; i<=100; i++){
            if(i % 2 != 0){
                numeroImpares.setText(numeroImpares.getText() + " "+ i);
            }
        }
    }
}