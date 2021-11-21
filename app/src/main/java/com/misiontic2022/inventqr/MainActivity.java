package com.misiontic2022.inventqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButtonbtnadmin;
    Button mButtonbtnvender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonbtnadmin = findViewById(R.id.btnadmin);
        mButtonbtnvender = findViewById(R.id.btnvender);


        mButtonbtnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSelectAuth();
            }
        });
        mButtonbtnvender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSelectAuth();
            }
        });
    }
    private void goToSelectAuth() {
        Intent intent =new Intent(MainActivity.this,SelectOptionAuthActivity.class );
        startActivity(intent);
    }
}