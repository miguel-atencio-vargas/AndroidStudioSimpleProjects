package com.example.clavedesarrollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String password = "Desarrollo2020";
    EditText passwordInput;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordInput = (EditText) findViewById(R.id.wPasswordText);
        message = (TextView) findViewById(R.id.wMessage);
    }
    public void comparePass(View v){
        if(passwordInput.getText().toString().equals(password)){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }else{
            message.setText("Contraseña incorrecta, intente nuevamente.");
        }
    }
}