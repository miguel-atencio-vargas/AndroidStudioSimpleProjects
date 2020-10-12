package com.example.player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mp;
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void playOnClick(View v){
        mp = MediaPlayer.create(this, R.raw.animals);
        mp.start();
    }
    public void pauseOnClick(View v){
        if(mp != null && mp.isPlaying()){
            pos = mp.getCurrentPosition();
            mp.pause();
        }
    }
    public void continueOnClick(View v){
        if(mp != null && !mp.isPlaying()){
            mp.seekTo(pos);
            mp.start();
        }
    }
    public void stopOnClick(View v){
        if(mp != null){
            mp.stop();
        }
        pos=0;
    }
    public void comeBack(View v){
        finish();
    }
}