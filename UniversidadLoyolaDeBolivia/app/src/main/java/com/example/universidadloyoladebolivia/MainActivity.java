package com.example.universidadloyoladebolivia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToInsert(View v){
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivity(intent);
    }
    public void goToList(View v){
        Intent intent = new Intent(this, ListData.class);
        startActivity(intent);
    }
    public void createDB(View v){
        String msg = "";
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "UNIVERSIDAD", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS alumnos");
            String cmdsql = "CREATE TABLE IF NOT EXISTS alumnos (id INTEGER PRIMARY KEY AUTOINCREMENT, codigo TEXT, apellidos TEXT, nombres TEXT, semestre TEXT, celular TEXT, direccion TEXT)";
            db.execSQL(cmdsql);
            db.close();
            msg += "Base de datos creada exitósamente!";
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        }catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}