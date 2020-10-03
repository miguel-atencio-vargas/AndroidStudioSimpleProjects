package com.example.arearectangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputBase, inputAltura;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBase = (EditText) findViewById(R.id.wBase);
        inputAltura = (EditText) findViewById(R.id.wAltura);
        result = (TextView) findViewById(R.id.wResult);
    }
    public void calculate(View v){
        int base = Integer.parseInt(inputBase.getText().toString());
        int altura = Integer.parseInt(inputAltura.getText().toString());
        int area = base * altura;
        result.setText("El área es: "+ area);
    }
}