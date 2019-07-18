package com.example.disinfection_tracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class OrderResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);
        Intent intent = getIntent();
        String accession = intent.getExtras().getString("accessionNumber");
        TextView mrnText = findViewById(R.id.pAccessionNumber);
        mrnText.setText(accession);
}
}
