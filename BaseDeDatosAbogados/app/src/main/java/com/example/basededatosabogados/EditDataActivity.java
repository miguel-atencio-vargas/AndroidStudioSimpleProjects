package com.example.basededatosabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditDataActivity extends AppCompatActivity {
    private TextView campoOuput;
    private EditText valorInput;
    private int idCampo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_activity);
        campoOuput = findViewById(R.id.wCampo);
        valorInput = findViewById(R.id.wValorInputToUpdate);
        Intent intent = getIntent();
        idCampo = intent.getIntExtra(AddDataActivity.ID_CAMPO, -1);
        obtenerCampo();
    }
    private void obtenerCampo(){
        String msg = "";
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM campos WHERE id_campo="+idCampo, null);
            if (c.moveToFirst()) {
                do {
                    String row = c.getString(c.getColumnIndex("campo"));
                    campoOuput.setText(row);
                    row = c.getString(c.getColumnIndex("value"));
                    valorInput.setText(row);
                } while (c.moveToNext());
            }
            c = db.rawQuery("SELECT value FROM campos WHERE id_campo="+idCampo, null);

            db.close();
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        }catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void update(View v){
        String msg = "";
        try{
            String value = valorInput.getText().toString();
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("value", value);
            db.update("campos", reg, "id_campo="+idCampo, null);
            db.close();
            msg +="Se actualizo el campo!";
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void delete(View v){
        String msg = "";
        try{
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.delete("campos", "id_campo="+idCampo, null);
            db.close();
            msg +="Se borró el campo!";
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void back(View v){
        finish();
    }
}