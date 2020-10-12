package com.example.diasdelmes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.wMessage);
        /*Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);*/
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.enero: message.setText("Enero tiene 31 dias"); break;
            case R.id.febrero: message.setText("Febrero tiene 28 dias"); break;
            case R.id.marzo: message.setText("Marzo tiene 31 dias"); break;
            case R.id.abril: message.setText("Abril tiene 30 dias"); break;
            case R.id.mayo: message.setText("Mayo tiene 31 dias"); break;
            case R.id.junio: message.setText("Junio tiene 30 dias"); break;
            case R.id.julio: message.setText("Julio tiene 31 dias"); break;
            case R.id.agosto: message.setText("Agosto tiene 31 dias"); break;
            case R.id.septiembre: message.setText("Septiembre tiene 30 dias"); break;
            case R.id.octubre: message.setText("Octubre tiene 31 dias"); break;
            case R.id.noviembre: message.setText("Noviembre tiene 30 dias"); break;
            case R.id.diciembre: message.setText("Diciembre tiene 31 dias"); break;
        }
    }
}