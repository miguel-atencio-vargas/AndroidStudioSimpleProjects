package com.example.sumarrestar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNum, secondNum;
    TextView resultView;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Ingrese sus numeros!!!", Toast.LENGTH_SHORT).show();
        resultView = findViewById(R.id.wResultado);
        firstNum = findViewById(R.id.wNum1);
        secondNum = findViewById(R.id.wNum2);
    }
    public void selectOperation(View v){
        int n1 = Integer.parseInt(firstNum.getText().toString());
        int n2 = Integer.parseInt(secondNum.getText().toString());
        switch (v.getId()){
            case R.id.wSumar: result = "La suma es: "+ (n1 + n2); break;
            case R.id.wRestar: result = "La resta es: " + (n1 - n2); break;
        }
    }
    public void show(View v){
        resultView.setText(result);
    }
}