package com.example.micalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1, number2;
    TextView resultado;
    private int subtotal = 0;
    private double subtotal2 = 0;
    Button sumar, restar, multiplicar, dividir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        resultado = (TextView)  findViewById(R.id.resultado);
        sumar = (Button) findViewById(R.id.sumar);
        restar = (Button) findViewById(R.id.restar);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);
        try {
            sumar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subtotal = Integer.parseInt(number1.getText().toString());
                    subtotal += Integer.parseInt(number2.getText().toString());
                    resultado.setText(String.valueOf(subtotal));
                }
            });
            restar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subtotal = Integer.parseInt(number1.getText().toString());
                    subtotal -= Integer.parseInt(number2.getText().toString());
                    resultado.setText(String.valueOf(subtotal));
                }
            });
            multiplicar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subtotal = Integer.parseInt(number1.getText().toString());
                    subtotal *= Integer.parseInt(number2.getText().toString());
                    resultado.setText(String.valueOf(subtotal));
                }
            });
            dividir.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {
                    subtotal2 = Double.parseDouble(number1.getText().toString());
                    if(number2.getText().toString().equals("0")){
                        resultado.setText("No existe la division entre cero.");
                    }else {
                        subtotal2 /= Double.parseDouble(number2.getText().toString());
                        resultado.setText(String.valueOf(subtotal2));
                    }
                }
            });
        }catch (Exception ex){
            resultado.setText(ex.getMessage());
        }

    }
}