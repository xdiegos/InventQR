package com.misiontic2022.inventqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanerQRActivity extends AppCompatActivity {

    Button btnqr;
    EditText txtresultado;

    private Button btncerrar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner_qractivity);


        btncerrar = findViewById(R.id.btnqrcerrar);
        btnqr = findViewById(R.id.btnqrscaner);
        txtresultado = findViewById(R.id.txtresultado);
        mAuth = FirebaseAuth.getInstance();

        btncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(ScanerQRActivity.this,MainActivity.class));
                finish();
            }
        });

        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrador = new IntentIntegrator(ScanerQRActivity.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector QR");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode, data);

        if( result != null){
            if( result.getContents() == null){
                Toast.makeText( this, "Lectura Cancelada", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText( this, result.getContents(), Toast.LENGTH_LONG).show();
                txtresultado.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}