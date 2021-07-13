package com.example.medicinereminderandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivityLogLogin extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnlogin;
    Button btnregister;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log_login);

        username=(EditText) findViewById(R.id.editTextloginUsername);
        password=(EditText) findViewById(R.id.editTextloginpassword);
        btnlogin=(Button) findViewById(R.id.buttonLoginin);
        btnregister = (Button) findViewById(R.id.buttonLoginregister);
        DB = new DatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("")||pass.equals("")) {
                    Toast.makeText(MainActivityLogLogin.this, "Please Enter Proper Details", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivityLogLogin.this, "Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivityLogLogin.this,"Username or Password is Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivityLog.class);
                startActivity(intent);
            }
        });
    }
}