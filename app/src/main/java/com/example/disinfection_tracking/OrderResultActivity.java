package com.example.disinfection_tracking;

//lines 5-32 written by Cristeen Adams

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class OrderResultActivity extends AppCompatActivity {

    public void clickConfirm(View view) {
        Intent Intent = new Intent(OrderResultActivity.this, TransducerActivity.class);
        startActivity(Intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);
        Intent intent = getIntent();
        String accessionNumber = intent.getExtras().getString("accessionNumber");
        TextView mrnText = findViewById(R.id.pAccessionNumber);
        mrnText.setText(accessionNumber);


    }
}



