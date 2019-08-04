package com.example.disinfection_tracking;

//lines 5-29 written by Cristeen Adams

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisinfectionConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection_confirmation);
    }

    public void clickScan(View view) {
        Intent Intent = new Intent(DisinfectionConfirmationActivity.this, OrderScanActivity.class);
        startActivity(Intent);
    }

    public void clickExit(View view) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

}