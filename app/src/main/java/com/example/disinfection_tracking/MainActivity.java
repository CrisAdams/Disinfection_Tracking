package com.example.disinfection_tracking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//Lines 15 - 57 written by Cristeen Olivero

    //variables for User ID, password, button, and Login Attempt Counter
    private EditText userId;
    private EditText password;
    private Button login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variables to xml layout ID(s)
        userId = findViewById(R.id.edUserId);
        password = findViewById(R.id.edpassword);
        login = findViewById(R.id.LoginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(userId.getText().toString(), password.getText().toString());

            }
        });

    }
    //validate User ID and password and continue to next activity in app
    private void  validate(String userID, String userPassword) {
        if ((userID.equals("Colivero")) && (userPassword.equals("2468"))) {
            Intent Intent = new Intent(MainActivity.this, OrderScanActivity.class);
            startActivity(Intent);

        //if unable to validate User ID or password disable login button after 3 attempts
        }else{
            counter--;
            //disable login button after 3 attempts
            if(counter == 0) {
                login.setEnabled(false);

            }
        }

    }
}