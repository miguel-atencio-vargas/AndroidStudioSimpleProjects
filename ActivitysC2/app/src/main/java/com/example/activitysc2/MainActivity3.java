package com.example.activitysc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity3 extends AppCompatActivity {
    TextView messageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        messageView = (TextView) findViewById(R.id.wText);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        messageView.setText(String.format("El parametro es: %s", bundle.getString("PARAM1")));

    }
}