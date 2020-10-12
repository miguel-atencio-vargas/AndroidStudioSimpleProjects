package com.example.actiobarcurriculum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Musica extends AppCompatActivity {
    private static MediaPlayer mediaPlayer;
    String[] songList = {"Gold Panda - In My Car"};
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        listView = findViewById(R.id.wListView);
        list.addAll(Arrays.asList(songList));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    mediaPlayer = MediaPlayer.create(Musica.this, R.raw.panda);
                    mediaPlayer.start();
                }
            }
        });
    }
}