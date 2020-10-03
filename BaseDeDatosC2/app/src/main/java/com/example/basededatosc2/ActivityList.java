package com.example.basededatosc2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.wListView);
        listSucursal();
    }
    private void listSucursal(){
        String msg = "";
        ArrayList<String> list = new ArrayList<String>();
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            @SuppressLint("Recycle") Cursor c = db.rawQuery("SELECT * FROM sucursal", null);
            if (c.moveToFirst()) {
                do {
                    String row = "ID: "+c.getInt(c.getColumnIndex("id_sucursal")) + "  Nombre: " + c.getString(c.getColumnIndex("sucursal")) + " Dirección: " + c.getString(c.getColumnIndex("direccion"));
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
    public void comeBack(View v){
        finish();
    }
}