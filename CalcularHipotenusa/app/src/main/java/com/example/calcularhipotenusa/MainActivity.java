package com.example.calcularhipotenusa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText iCatetoC, iCatetoB;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iCatetoB = (EditText) findViewById(R.id.wCatetoB);
        iCatetoC = (EditText) findViewById(R.id.wCatetoC);
        result = (TextView) findViewById(R.id.wResult);
    }
    public void calc(View v){
        int c = Integer.parseInt(iCatetoC.getText().toString());
        int b = Integer.parseInt(iCatetoB.getText().toString());
        double hipo = Math.hypot(c,b);
        result.setText("La hipotenusa es: "+ hipo);
    }
    public void clean(View v){
        iCatetoB.setText("");
        iCatetoC.setText("");
        result.setText("Calcular la hipotenusa del triangulo rectangulo");
    }
}