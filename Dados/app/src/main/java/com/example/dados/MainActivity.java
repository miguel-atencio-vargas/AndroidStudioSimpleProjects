package com.example.dados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button btn;
    public int s0 = 132;
    private ImageView imgAleat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAleat = (ImageView) findViewById(R.id.wImage);
        btn = (Button) findViewById(R.id.wBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public  void play(View v){
        Random s1 = new Random(s0);
        int aleatory = s1.nextInt(16-11+1)+11;
        aleatory-=10;
        switch (aleatory){
            case 1: imgAleat.setImageResource(R.drawable.frame_1); break;
            case 2: imgAleat.setImageResource(R.drawable.frame_2); break;
            case 3: imgAleat.setImageResource(R.drawable.frame_3); break;
            case 4: imgAleat.setImageResource(R.drawable.frame_4); break;
            case 5: imgAleat.setImageResource(R.drawable.frame_5); break;
            case 6: imgAleat.setImageResource(R.drawable.frame_6); break;
        }
        s0+=31;
    }
}