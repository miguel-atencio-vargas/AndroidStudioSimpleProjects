package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double mean=0;
    EditText[] notes = new EditText[4];
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes[0] = (EditText) findViewById(R.id.wFirtsNote);
        notes[1] = (EditText) findViewById(R.id.wSecondNote);
        notes[2] = (EditText) findViewById(R.id.wThirdNote);
        notes[3] = (EditText) findViewById(R.id.wFouthNote);

        message = (TextView)  findViewById(R.id.wMessage);
    }
    @SuppressLint("SetTextI18n")
    public void setBntCalculate(View v){
        boolean s = true;
        for(int i=0; i<4; i++){
            if(Integer.parseInt(notes[i].getText().toString())<=20){
                mean += Double.parseDouble(notes[i].getText().toString());
            }else{
                s = false;
            }
        }
        if(s){
            mean = mean / 4;
            if(mean<=10.5){
                message.setText("Usted es un estudiante MALO tiene: "+ mean);
            }else if(mean<=14){
                message.setText("Usted es un estudiante REGULAR tiene: "+mean);
            }else if(mean<=18){
                message.setText("Usted es un estudiante BUENO tiene: "+mean);
            }else{
                message.setText("Usted es un estudiante EXCELENTE tiene: "+mean);
            }
        }else{
            message.setText("Tiene que ingresar notas entre 0 y 20");
        }
        mean = 0;
    }
}