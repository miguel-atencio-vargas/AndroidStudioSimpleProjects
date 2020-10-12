package com.example.basededatosabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String ID_ABOGADO = "com.example.basededatosabogados.ID_ABOGADO";
    public static final String NAME = "com.example.basededatosabogados.NAME";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.wListView);
        createDB();
        listAbogados();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
                intent.putExtra(ID_ABOGADO, position+1);
                intent.putExtra(NAME, ((TextView) view).getText());
                startActivity(intent);
            }
        });
    }
    public void goToInsert(View v){
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }
    private void listAbogados(){
        String msg = "";
        ArrayList<String> list = new ArrayList<String>();
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM abogados", null);
            if (c.moveToFirst()) {
                do {
                    String row = c.getString(c.getColumnIndex("name"));
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
    private void createDB(){
        String msg = "";
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            String cmdsql = "CREATE TABLE IF NOT EXISTS abogados (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
            //db.execSQL("DROP TABLE IF EXISTS abogados");
            db.execSQL(cmdsql);
            cmdsql = "CREATE TABLE IF NOT EXISTS campos (id_campo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "campo TEXT, value TEXT, " +
                    "id_abogado INTEGER, " +
                    "FOREIGN KEY(id_abogado) REFERENCES abogados(id))";
            //db.execSQL("DROP TABLE IF EXISTS campos");
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