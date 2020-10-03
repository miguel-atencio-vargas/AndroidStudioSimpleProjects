package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String total;
    TextView resScreen;
    EditText num1, num2;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.number1);
        num2 = (EditText) findViewById(R.id.number2);
        resScreen = (TextView)  findViewById(R.id.resultado);
        calcular = (Button) findViewById(R.id.calcular);

        for(int i=0; i<4; i++){
            Toast toast = Toast.makeText(this, "Ingrese sus numeros", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }
    public void onRadioButtonClicked(View view) {
        try {
            switch(view.getId()) {
                case R.id.sumar:
                    int subTotal = Integer.parseInt(num1.getText().toString());
                    subTotal += Integer.parseInt(num2.getText().toString());
                    total = String.valueOf(subTotal);
                    break;
                case R.id.restar:
                    subTotal = Integer.parseInt(num1.getText().toString());
                    subTotal -= Integer.parseInt(num2.getText().toString());
                    total = String.valueOf(subTotal);
                    break;
                case R.id.multiplicar:
                    subTotal = Integer.parseInt(num1.getText().toString());
                    subTotal *= Integer.parseInt(num2.getText().toString());
                    total = String.valueOf(subTotal);
                    break;
                case R.id.dividir:
                    double subTotalDouble = Integer.parseInt(num1.getText().toString());
                    if(num2.getText().toString().equals("0")){
                        total = "No existe la division entre cero.";
                    }else {
                        subTotalDouble /= Integer.parseInt(num2.getText().toString());
                        total = String.valueOf(subTotalDouble);
                    }
                    break;
                default:
                    throw new IllegalStateException("Valor no esperado: " + view.getId());
            }
        }catch (Exception ex){
            resScreen.setText(ex.getMessage());
        }
    }
    public void showResult(View view){
        resScreen.setText(total);
        Toast toast2 = Toast.makeText(this, "Operacion ejecutada exitosamente!", Toast.LENGTH_LONG);
        toast2.show();
    }
}