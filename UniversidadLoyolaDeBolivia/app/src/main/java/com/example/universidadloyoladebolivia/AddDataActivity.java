package com.example.universidadloyoladebolivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {
    EditText codigoInput, apellidosInput, nombresInput, semestreInput, celularInput, direccionInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        codigoInput = findViewById(R.id.wCodigo);
        apellidosInput = findViewById(R.id.wApellido);
        nombresInput = findViewById(R.id.wNombre);
        semestreInput = findViewById(R.id.wSemestre);
        celularInput = findViewById(R.id.wCelular);
        direccionInput = findViewById(R.id.wDireccion);
    }
    public void insertData(View v){
        String msg = "";
        try{
            String codigo = codigoInput.getText().toString(),
                    apellidos = apellidosInput.getText().toString(),
                    nombres = nombresInput.getText().toString(),
                    semestre = semestreInput.getText().toString(),
                    celular = celularInput.getText().toString(),
                    direccion = direccionInput.getText().toString();
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "UNIVERSIDAD", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("codigo", codigo);
            reg.put("apellidos", apellidos);
            reg.put("nombres", nombres);
            reg.put("semestre", semestre);
            reg.put("celular", celular);
            reg.put("direccion", direccion);
            db.insert("alumnos",null, reg);
            db.close();
            msg +="Se insertó con éxito el nuevo alumno!";
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void back(View v){
        finish();
    }
}