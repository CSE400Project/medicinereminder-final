package com.example.medicinereminderandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listViewId);

        final String[] animeName = getResources().getStringArray(R.array.medicine_name);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this,R.layout.sample_view,R.id.textViewId,animeName);
        listView.setAdapter(adapter);


    }
}