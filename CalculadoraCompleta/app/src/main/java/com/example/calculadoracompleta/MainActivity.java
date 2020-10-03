package com.example.calculadoracompleta;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView result, operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.wResult);
        operation = (TextView) findViewById(R.id.wOperation);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.w1:
                String aux= operation.getText().toString();
                aux+="1";
                operation.setText(aux);break;
            case R.id.w2:
                aux= operation.getText().toString();
                aux+="2";
                operation.setText(aux);break;
            case R.id.w3:
                aux= operation.getText().toString();
                aux+="3";
                operation.setText(aux);break;
            case R.id.w4:
                aux= operation.getText().toString();
                aux+="4";
                operation.setText(aux);break;
            case R.id.w5:
                aux= operation.getText().toString();
                aux+="5";
                operation.setText(aux);break;
            case R.id.w6:
                aux= operation.getText().toString();
                aux+="6";
                operation.setText(aux);break;
            case R.id.w7:
                aux= operation.getText().toString();
                aux+="7";
                operation.setText(aux);break;
            case R.id.w8:
                aux= operation.getText().toString();
                aux+="8";
                operation.setText(aux);break;
            case R.id.w9:
                aux= operation.getText().toString();
                aux+="9";
                operation.setText(aux);break;
            case R.id.wZero:
                aux= operation.getText().toString();
                aux+="0";
                operation.setText(aux);break;
            case R.id.wMultiply:
                aux= operation.getText().toString();
                aux+="*";
                operation.setText(aux);break;
            case R.id.wPlus:
                aux= operation.getText().toString();
                aux+="+";
                operation.setText(aux);break;
            case R.id.wRest:
                aux= operation.getText().toString();
                aux+="-";
                operation.setText(aux);break;
            case R.id.wDivide:
                aux= operation.getText().toString();
                aux+="/";
                operation.setText(aux);break;
            case R.id.wDot:
                aux= operation.getText().toString();
                aux+=".";
                operation.setText(aux); break;
        }
    }
    public void calcular(View v) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine =  new ScriptEngineManager().getEngineByName("rhino");
        String operacion = operation.getText().toString();
        result.setText(engine.eval(operacion).toString());
    }
    public void clean(View v){
        result.setText("");
    }
}