package com.misiontic2022.inventqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mButtonbtnregistro;
    Button mButtonbtnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonbtnregistro = findViewById(R.id.btnregistro);
        mButtonbtnlogin = findViewById(R.id.btn_login);


        mButtonbtnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSelectAuth();
            }
        });
        mButtonbtnlogin.setOnClickListener(view -> onClick(view));
    }

    private void goToSelectAuth2() {
        Intent intent =new Intent(MainActivity.this,LoginActivity.class );
        startActivity(intent);
    }


    private void goToSelectAuth() {
        Intent intent2 =new Intent(MainActivity.this,Register.class );
        startActivity(intent2);

    }

    public void onClick(View view) {
        goToSelectAuth2();
    }
}