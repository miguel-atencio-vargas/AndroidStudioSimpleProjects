package com.example.estudiantenota;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView message;
    EditText iName, iNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView) findViewById(R.id.wMessage);
        iName = (EditText) findViewById(R.id.wName);
        iNote = (EditText) findViewById(R.id.wNota);
    }
    @SuppressLint("SetTextI18n")
    public void mostrar(View v){
        int nota = Integer.parseInt(iNote.getText().toString());
        if(nota >= 51){
            message.setText("El estudiante: "+ iName.getText().toString()+ " aprobó con: "+ nota);
        }else{
            message.setText("El estudiante: "+ iName.getText().toString()+ " reprobo con: "+ nota);
        }
    }
    public void clean(View v){
        message.setText("Verifique si aprobo la materia");
        iName.setText("");
        iNote.setText("");
    }
}