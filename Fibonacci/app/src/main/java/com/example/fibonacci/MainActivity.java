package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView outputNumbers;
    EditText inputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputNumbers = (TextView) findViewById(R.id.wOutput);
        inputNum = (EditText) findViewById(R.id.wInput);
    }
    public void generate(View v){
        ArrayList <Long> fibo = new ArrayList<>();
        fibo.add(1L); fibo.add(1L);
        int n = Integer.parseInt(inputNum.getText().toString());
        if(n==0){
            outputNumbers.setText("Ingrese un numero mayor a 0");
        }else if(n==1){
            outputNumbers.setText("1");
        }else if(n==2){
            outputNumbers.setText("1, 1");
        }else{
            for(int i=2; i<n; i++) fibo.add(fibo.get(i - 2) + fibo.get(i - 1));
            StringBuilder nums = new StringBuilder();
            for(int i=1; i<=fibo.size(); i++){
                if(i!=fibo.size()){
                    nums.append(fibo.get(i-1)+", ");
                }else{
                    nums.append(fibo.get(i-1));
                }
            }
            outputNumbers.setText(nums);
        }
    }
}