package com.example.disinfection_tracking;

//Lines 5 - 26 written by Cristeen Adams

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TransducerActivity extends AppCompatActivity {

    public void clickSave (View view){

    Intent Intent = new Intent(TransducerActivity.this, DisinfectionScanActivity.class);
    startActivity(Intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transducer);


    }
}
