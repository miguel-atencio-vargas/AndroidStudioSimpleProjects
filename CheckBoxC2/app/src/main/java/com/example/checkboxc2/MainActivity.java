package com.example.checkboxc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String rSuma="", rResta="", rMulti="";
    EditText iNum1, iNum2;
    TextView oSuma, oResta, oMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iNum1 = (EditText) findViewById(R.id.wInputN1);
        iNum2 = (EditText) findViewById(R.id.wInputN2);
        oSuma = (TextView) findViewById(R.id.wOutputSuma);
        oResta = (TextView) findViewById(R.id.wOutputResta);
        oMulti = (TextView) findViewById(R.id.wOutputMultiplicacion);
    }

    public void onCheckboxClicked(View v){
        boolean checked = ((CheckBox) v).isChecked();
        int num1 = Integer.parseInt(iNum1.getText().toString());
        int num2 = Integer.parseInt(iNum2.getText().toString());
        switch (v.getId()){
            case R.id.sumar:       if (checked){rSuma = String.valueOf(num1 +num2);  break;}
            case R.id.restar:      if (checked){rResta = String.valueOf(num1 -num2); break;}
            case R.id.multiplicar: if (checked){rMulti = String.valueOf(num1 *num2); break;}
        }
    }
    public void showResult(View v){
        oSuma.setText(rSuma);
        oResta.setText(rResta);
        oMulti.setText(rMulti);
    }
}