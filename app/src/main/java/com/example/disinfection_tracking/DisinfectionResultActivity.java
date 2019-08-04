package com.example.disinfection_tracking;

//lines 5-33 written by Cristeen Adams

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisinfectionResultActivity extends AppCompatActivity {

    public void clickDisinfectionConfirm(View view) {
        Intent Intent = new Intent(com.example.disinfection_tracking.DisinfectionResultActivity.this, DisinfectionConfirmationActivity.class);
        startActivity(Intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection_result);
        Intent intent = getIntent();
        String disinfectionResult = intent.getExtras().getString("disinfectionResult");
        TextView testResult = findViewById(R.id.testResult);
        testResult.setText(disinfectionResult);


    }
}




