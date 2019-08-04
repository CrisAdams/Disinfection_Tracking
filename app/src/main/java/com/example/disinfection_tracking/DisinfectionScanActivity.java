package com.example.disinfection_tracking;

import androidx.appcompat.app.AppCompatActivity;

//Lines 5 - 56 written by Cristeen Adams

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DisinfectionScanActivity extends AppCompatActivity {
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection_scan);

        qrScan = new IntentIntegrator(this);

    }
    public void scan(View view) {
        qrScan.initiateScan();
}

    @Override
    protected  void  onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() ==null) {
                Toast.makeText(this, "No Results Found", Toast.LENGTH_SHORT).show();
            }else {

                String disinfectionResult = result.getContents();
                Intent intent = new Intent (this, DisinfectionResultActivity.class);
                intent.putExtra("disinfectionResult", disinfectionResult);


                startActivity(intent);

            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}