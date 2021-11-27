package com.misiontic2022.inventqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText mEditTextUser;
    private EditText mEditTextMail;
    private EditText mEditTextPassword;
    private Button mButtonRegister;
    private Button mButtonSalir;

    //VARIABLES DE LOS DATOS

    private String User = "";
    private String Mail = "";
    private String Password = "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mEditTextUser = (EditText) findViewById(R.id.rg_user);
        mEditTextMail = (EditText) findViewById(R.id.rg_email);
        mEditTextPassword = (EditText) findViewById(R.id.rg_password);
        mButtonRegister = (Button) findViewById(R.id.btnRegister);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User = mEditTextUser.getText().toString();
                Mail = mEditTextMail.getText().toString();
                Password = mEditTextPassword.getText().toString();


                if (!User.isEmpty() && !Mail.isEmpty() && !Password.isEmpty()) {

                    if (Password.length()>= 6){
                        registerUser();
                    }
                    else {
                        Toast.makeText(Register.this, "La contraseña debe tener almenos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(Register.this, "Debe Completar los campos", Toast.LENGTH_SHORT).show();;
                }
            }
        });

    }

    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(Mail, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("User", User);
                    map.put("Mail", Mail);
                    map.put("Password", Password);


                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("user").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {
                                startActivity(new Intent(Register.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(Register.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                } else {
                    Toast.makeText(Register.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();{


                    }
                }
            }
        });
    }
}





