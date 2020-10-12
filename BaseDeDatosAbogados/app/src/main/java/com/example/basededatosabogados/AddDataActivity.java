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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddDataActivity extends AppCompatActivity {
    TextView nombreAbogadoOutput;
    ListView listViewAbogado;
    int idAbogado;
    EditText campoInput, valorInput;
    public static final String ID_CAMPO = "com.example.basededatosabogados.ID_CAMPO";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data_activity);
        nombreAbogadoOutput = findViewById(R.id.wNombreAbogado);
        listViewAbogado = findViewById(R.id.wListViewAbogado);
        campoInput = findViewById(R.id.wCampoInput);
        valorInput = findViewById(R.id.wValorInput);

        Intent intent = getIntent();
        idAbogado = intent.getIntExtra(MainActivity.ID_ABOGADO, -1);
        nombreAbogadoOutput.setText("Abogado " + intent.getStringExtra(MainActivity.NAME)+" tiene los siguientes datos:");
        listViewAbogado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idCampo = ((TextView) view).getText().toString();
                int position = idCampo.indexOf(':');
                position = Integer.parseInt(idCampo.substring(0, position));
                Intent intent = new Intent(AddDataActivity.this, EditDataActivity.class);
                intent.putExtra(ID_CAMPO, position);
                startActivity(intent);
            }
        });
        listAbogados();
    }
    private void listAbogados(){
        String msg = "";
        ArrayList<String> list = new ArrayList<String>();
        try {
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM campos WHERE id_abogado="+idAbogado, null);
            if (c.moveToFirst()) {
                do {
                    String row = c.getInt(c.getColumnIndex("id_campo")) +": "+
                            c.getString(c.getColumnIndex("campo")) +" "+
                            c.getString(c.getColumnIndex("value"));
                    list.add(row);
                } while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            listViewAbogado.setAdapter(adapter);
            db.close();
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        }catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void insertCampo(View v){
        String msg = "";
        try{
            String campo = campoInput.getText().toString();
            String valor = valorInput.getText().toString();
            AdminSqliteOpenHelper admin = new AdminSqliteOpenHelper(this, "BUFFET", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues reg = new ContentValues();
            reg.put("campo", campo);
            reg.put("value", valor);
            reg.put("id_abogado", idAbogado);
            db.insert("campos",null, reg);
            db.close();
            msg += "Se inserto el campo correctamente";
        }catch (SQLException ex){
            msg  += "Error SQLite: "+ ex.getMessage();
        } catch (Exception ex){
            msg += "Error: "+ ex.getMessage();
        }
        campoInput.setText("");
        valorInput.setText("");
        listAbogados();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    public void back(View v){
        finish();
    }
}