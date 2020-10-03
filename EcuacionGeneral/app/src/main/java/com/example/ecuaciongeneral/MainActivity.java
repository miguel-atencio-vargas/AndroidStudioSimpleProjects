package com.example.ecuaciongeneral;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.StrictMath.pow;

public class MainActivity extends AppCompatActivity {
    public double a, b, c, discriminante;
    EditText  inputA, inputB, inputC;
    TextView outputX1, outputX2, message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputA = (EditText) findViewById(R.id.wInputA);
        inputB = (EditText) findViewById(R.id.wInputB);
        inputC = (EditText) findViewById(R.id.wInputC);
        outputX1 = (TextView) findViewById(R.id.wOutputX1);
        outputX2 = (TextView) findViewById(R.id.wOutputX2);
        message = (TextView) findViewById(R.id.wMessage);
    }
    @SuppressLint("SetTextI18n")
    public void calcRoots(View v){
        a = Double.parseDouble(inputA.getText().toString());
        b = Double.parseDouble(inputB.getText().toString());
        c = Double.parseDouble(inputC.getText().toString());
        if (a == 0) {
            message.setText("El coeficiente a no puede ser igual a cero");
        } else {
            discriminante = pow(b, 2) - 4 * a * c;
            if (discriminante >= 0) {
                if (discriminante == 0) {
                    double x = -b / (2 * a);
                    outputX1.setText("La raíz única es: "+ x);
                } else {
                    double x1, x2;
                    x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                    x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                    outputX1.setText("La raíz real x1 es:  "+ x1);
                    outputX2.setText("La raíz real x2 es:  "+ x2);
                }
            } else {
                double parteReal, parteImaginaria;
                discriminante = Math.abs(discriminante);
                parteReal = -b / (2 * a);
                parteImaginaria = Math.sqrt(discriminante) / (2 * a);
                outputX1.setText("La raíz compleja x1 es "+parteReal+" + "+parteImaginaria);
                outputX2.setText("La raíz compleja x2 es "+ parteReal+" - "+ parteImaginaria);
            }
        }
    }
}