package com.example.medicinereminderandroidapp;
//MainActivityLog = registration
//
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityLog extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText repassword;
    Button register, login;
    DatabaseHelper DB;
    //private int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);

        username = (EditText) findViewById(R.id.editTextregUsername);
        password = (EditText) findViewById(R.id.editTextregPassword);
        repassword = (EditText) findViewById(R.id.editTextregconPassword);
        register = (Button) findViewById(R.id.buttonNewRegister);
        DB = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(MainActivityLog.this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivityLog.this, "Successfully Registried",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivityLogLogin.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivityLog.this, "Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivityLog.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivityLog.this,"Password not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.loginId){
            Toast.makeText(MainActivityLog.this, "Login is selected",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivityLog.this,MainActivityLogLogin.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId() == R.id.aboutUsId){
            Toast.makeText(MainActivityLog.this, "About Us is selected",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivityLog.this,AboutUs.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}