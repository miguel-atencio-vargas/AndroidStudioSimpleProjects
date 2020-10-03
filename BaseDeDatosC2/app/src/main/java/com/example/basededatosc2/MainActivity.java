package com.example.basededatosc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button createBtn, insertBtn, listBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createBtn = (Button) findViewById(R.id.wBtnCreate);
        insertBtn = (Button) findViewById(R.id.wBtnInsert);
        listBtn = (Button) findViewById(R.id.wBtnList);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTable();
            }
        });
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityToCreate.class);
                startActivity(intent);
            }
        });
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityList.class);
                startActivity(intent);
            }
        });

    }
    private void createTable(){
        String msg = "";
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            String cmdsql = "CREATE TABLE sucursal (id_sucursal INTEGER PRIMARY KEY AUTOINCREMENT, sucursal TEXT, direccion TEXT)";
            db.execSQL("DROP TABLE IF EXISTS sucursal");
            db.execSQL(cmdsql);
            db.close();
            msg += "Tabla sucursal creada exitósamente!";
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        }catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
    }
}
