package com.example.actiobarcurriculum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.option1){
            Intent curriculumIntent = new Intent(this, Curriculum.class);
            startActivity(curriculumIntent);
        }
        if(id == R.id.option2){
            Intent musicaIntent = new Intent(this, Musica.class);
            startActivity(musicaIntent);
        }
        if(id == R.id.option3){
            Intent casaIntent = new Intent(this, Casa.class);
            startActivity(casaIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}