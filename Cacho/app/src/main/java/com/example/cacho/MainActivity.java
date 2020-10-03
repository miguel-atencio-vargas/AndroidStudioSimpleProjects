package com.example.cacho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView dado1, dado2;
    private int s0 = 247;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dado1 = (TextView) findViewById(R.id.wDado1);
        dado2 = (TextView) findViewById(R.id.wDado2);
    }
    public void lanzarDados(View v){
        Random s1 = new Random(s0);
        Random s2 = new Random(s0+57);
        int n1 = s1.nextInt(16-11+1)+11;
        int n2 = s2.nextInt(16-11+1)+11;
        dado1.setText(String.valueOf(n1-10));
        dado2.setText(String.valueOf(n2-10));
        s0+=19;
    }
}