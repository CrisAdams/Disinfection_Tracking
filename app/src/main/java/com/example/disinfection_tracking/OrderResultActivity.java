package com.example.disinfection_tracking;

//lines 5-32 written by Cristeen Adams

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class OrderResultActivity extends AppCompatActivity {

    private String accessionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        Intent intent = getIntent();
        accessionNumber = intent.getExtras().getString("accessionNumber");

        downloadJSON("http://10.0.2.2/db_connect.php");
    }

    private void    downloadJSON(final String urlWebService) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

        @Override
                protected  void onPreExecute() {
                super.onPreExecute();
        }

        @Override
                protected void onPostExecute(String s) {
            super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        @Override
                protected  String doInBackground(Void... voids) {
            try {
                URL url = new URL(urlWebService);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String json;
                while ((json = bufferedReader.readLine()) != null) {
                    sb.append(json + "\n");
                }
                return sb.toString().trim();
            } catch (Exception e) {
                return null;
            }
        }
    }
    DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();




    }

    private void loadIntoListView(String json) throws JSONException {
        List<Patient> patientList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        //String[] info = new String[jsonArray.length()];
        for (int i=0; i<jsonArray.length(); i++) {

            JSONObject obj = jsonArray.getJSONObject(i);
           Patient patient = new Patient();
           patient.setMEDICALRECORDNUMBER(obj.getString("MEDICAL_RECORD_NUMBER"));
           patient.setFIRSTNAME(obj.getString("FIRST_NAME"));
           patient.setLASTNAME(obj.getString("LAST_NAME"));
           patient.setDATEOFBIRTH(obj.getString("DATE_OF_BIRTH"));
           patient.setACCESSIONNUMBER(obj.getString("ACCESSION_NUMBER"));
           patient.setORDERDATE(obj.getString("ORDER_DATE"));
           patient.setEXAMDESCRIPTION(obj.getString("EXAM_DESCRIPTION"));
           patientList.add(patient);
        }

        for (Patient patient: patientList) {
            if (patient.getACCESSIONNUMBER().equals(accessionNumber)) {

                TextView pName = findViewById(R.id.pName);
                pName.setText(patient.getFIRSTNAME() + " " + patient.getLASTNAME());
            }
        }

    }
    public void clickConfirm(View view) {
        Intent Intent = new Intent(OrderResultActivity.this, TransducerActivity.class);
        startActivity(Intent);

    }

    }



