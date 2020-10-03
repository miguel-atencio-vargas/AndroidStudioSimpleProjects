package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView list1;
    private String[] courses = {"Python", "Javascript", "Fortran", "C++", "Cobol", "Ruby", "Java", "Go"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.wCoursesList);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courses);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, courses[i], Toast.LENGTH_LONG).show();
            }
        });
    }

}