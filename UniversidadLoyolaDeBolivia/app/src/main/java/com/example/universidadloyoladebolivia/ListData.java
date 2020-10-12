package com.example.universidadloyoladebolivia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        listView = findViewById(R.id.wListView);
        listAbogados();
    }
    private void listAbogados(){
        String msg = "";
        ArrayList<String> list = new ArrayList<String>();
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "UNIVERSIDAD", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM alumnos", null);
            if (c.moveToFirst()) {
                do {
                    String row = "Codigo: "+c.getString(c.getColumnIndex("codigo"));
                    row += " Apellidos: "+ c.getString(c.getColumnIndex("apellidos"));
                    row += " Nombres: "+ c.getString(c.getColumnIndex("nombres"));
                    row += " Semestre: "+ c.getString(c.getColumnIndex("semestre"));
                    row += " Celular: "+ c.getString(c.getColumnIndex("celular"));
                    row += " Direccion: "+ c.getString(c.getColumnIndex("direccion"));
                    list.add(row);
                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
            db.close();
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        }catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void back(View v){
        finish();
    }
}