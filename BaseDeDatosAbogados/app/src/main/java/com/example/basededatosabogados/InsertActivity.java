package com.example.basededatosabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText nameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        nameInput = findViewById(R.id.wName);
    }
    public void insertData(View v){
        String msg = "";
        try{
            String name = nameInput.getText().toString();
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("name", name);
            db.insert("abogados",null,reg);
            db.close();
            msg +="Se insertó con éxito el nuevo abogado!";
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}