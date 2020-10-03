package com.example.preferencesc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.wInput1);
        message = (TextView) findViewById(R.id.wOutputMessage);
    }
    public void save(View v){
        String inputEmail = email.getText().toString();
        SharedPreferences prefs = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", inputEmail);
        boolean b = editor.commit();
        if(b){
            Toast.makeText(this, "Se guardo el email", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No se pudo guardar el email", Toast.LENGTH_SHORT).show();
        }
    }
    public void getEmail(View v){
        SharedPreferences prefs = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        message.setText(prefs.getString("email", ""));
    }
}