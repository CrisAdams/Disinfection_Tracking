package com.example.disinfection_tracking;

//Lines 4 - 56 written by Cristeen Olivero
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class OrderScanActivity extends AppCompatActivity {
private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_scan);

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

                String accessionNumber = result.getContents();
                Intent intent = new Intent (this, OrderResultActivity.class);
                intent.putExtra("accessionNumber", accessionNumber);
                startActivity(intent);

                }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
