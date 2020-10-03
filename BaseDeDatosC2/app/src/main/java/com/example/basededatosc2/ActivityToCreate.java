package com.example.basededatosc2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class ActivityToCreate extends AppCompatActivity {
    EditText nameInput, directionInput;
    Button createBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_create);

        nameInput = (EditText) findViewById(R.id.wInputSucursal);
        directionInput = (EditText) findViewById(R.id.wInputDireccion);
        createBtn = (Button) findViewById(R.id.wBtnSave);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }
    public void insertData(){
        String msg = "";
        try{
            String sucursal = nameInput.getText().toString();
            String direccion = directionInput.getText().toString();
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("sucursal", sucursal);
            reg.put("direccion", direccion);
            db.insert("sucursal",null,reg);
            db.close();
            nameInput.setText("");
            directionInput.setText("");
            msg +="Se insertó con éxito la tabla sucursal!";
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void comeBack(View v){
        finish();
    }
}
