package com.misiontic2022.inventqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButtonbtnregistro;
    Button mButtonbtnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonbtnregistro = findViewById(R.id.btnregistro);
        mButtonbtnlogin = findViewById(R.id.btnlogin);


        mButtonbtnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSelectAuth();
            }
        });
        mButtonbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSelectAuth2();
            }
        });
    }

    private void goToSelectAuth2() {
        Intent intent =new Intent(MainActivity.this,LoginActivity.class );
        startActivity(intent);
    }


    private void goToSelectAuth() {
        Intent intent =new Intent(MainActivity.this,Register.class );
        startActivity(intent);

    }
}