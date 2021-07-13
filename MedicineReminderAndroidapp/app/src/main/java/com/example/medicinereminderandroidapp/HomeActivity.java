package com.example.medicinereminderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button patientButton,medicineButton,remButton;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        patientButton = (Button) findViewById(R.id.patientId);
        medicineButton = (Button) findViewById(R.id.medicineId);
        remButton = (Button) findViewById(R.id.remId);

        patientButton.setOnClickListener(this);
        medicineButton.setOnClickListener(this);
        remButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.patientId){
            intent = new Intent(HomeActivity.this,MainActivity.class);//patient info
            startActivity(intent);
        }if(v.getId()==R.id.medicineId){
            intent = new Intent(HomeActivity.this,ListActivity.class);//medicine list
            startActivity(intent);
        }if(v.getId()==R.id.remId){
            intent = new Intent(HomeActivity.this,MainActivity2.class);//reminder
            startActivity(intent);
        }
    }

}

