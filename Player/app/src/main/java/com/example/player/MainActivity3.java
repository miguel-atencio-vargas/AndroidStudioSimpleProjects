package com.example.player;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {
    VideoView video;
    private int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        video = (VideoView) findViewById(R.id.wVideo);
    }
    public void playVideo(View v){
        String path = "android.resource://com.example.player/"+R.raw.video;
        Uri u = Uri.parse(path);
        video.setVideoURI(u);
        video.start();
    }
    public void pauseOnClick(View v){
        if(video != null && video.isPlaying()){
            pos = video.getCurrentPosition();
            video.pause();
        }
    }
    public void continueOnClick(View v){
        if(video != null && !video.isPlaying()){
            video.seekTo(pos);
            video.start();
        }
    }
    public void stopOnClick(View v){
        if(video != null){
            video.stopPlayback();
        }
    }
    public void comeBack(View v){
        finish();
    }
}