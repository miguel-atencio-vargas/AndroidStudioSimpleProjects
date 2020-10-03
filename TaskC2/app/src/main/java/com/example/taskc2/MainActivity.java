package com.example.taskc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView label;
    Button startBtn, cancelBtn;
    private int nums = 10000;
    private SimpleTask simpleTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.wMsg);
        startBtn = (Button) findViewById(R.id.wInit);
        cancelBtn = (Button) findViewById(R.id.wCancel);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleTask = new SimpleTask();
                simpleTask.execute();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleTask.cancel(true);
            }
        });

    }
    private class SimpleTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params){
            int aux;
            for (int i=0; i<nums; i++){
                if(!isCancelled())
                    publishProgress((int) ((i / (float) nums) * 100));
                else break;
            }
            return null;
        }
        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
            label.setText("En espera...");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            label.setText(values[0]+ "0%");
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            label.setText("Completado");
        }
    }
}