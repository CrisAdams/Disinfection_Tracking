package com.example.disinfection_tracking;

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
private TextView pName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_scan);
       // pName = (TextView)findViewById(R.id.pName);

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
                Intent Intent = new Intent(OrderScanActivity.this, OrderResult.class);
                //startActivity(Intent);
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();                try {
                    JSONObject object = new JSONObject(result.getContents());
                    //pName.setText(object.getString("name"));

                   /

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
