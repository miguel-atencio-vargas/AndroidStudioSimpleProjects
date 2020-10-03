package com.example.soundsc2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    int pos = 0;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (TextView) findViewById(R.id.wTime);
    }
    public void playOnClick(View v){
        mp = MediaPlayer.create(this, R.raw.notes);
        mp.start();
        time.setText("sec: "+ pos/1000);
    }
    public void pauseOnClick(View v){
        if(mp != null && mp.isPlaying()){
            pos = mp.getCurrentPosition();
            mp.pause();
        }
        time.setText("sec: "+ pos/1000);
    }
    public void continueOnClick(View v){
        if(mp != null && !mp.isPlaying()){
            mp.seekTo(pos);
            mp.start();
        }
        time.setText("sec: "+ pos/1000);
    }
    public void stopOnClick(View v){
        if(mp != null){
            mp.stop();
        }
        pos=0;
        time.setText("sec: "+ pos/1000);
    }
}