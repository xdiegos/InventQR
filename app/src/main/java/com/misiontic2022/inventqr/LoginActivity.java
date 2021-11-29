package com.misiontic2022.inventqr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditTextmail;
    private EditText mEditTextpassword;
    private Button mButtonLogin;


    private String mail = "";
    private String password = "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mEditTextmail = (EditText) findViewById(R.id.txtMaillogin);
        mEditTextpassword = (EditText) findViewById(R.id.txtpasswordlogin);
        mButtonLogin = (Button) findViewById(R.id.btnlogin);



        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mail = mEditTextmail.getText().toString();
                 password = mEditTextpassword.getText().toString();

                        if (!mail.isEmpty() && !password.isEmpty()) {
                            loginUser();
                        } else {
                            Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
    private void loginUser (){
        Task<AuthResult> onCompleteListener = mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(LoginActivity.this, ScanerQRActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "No se pudo iniciar sesion compruebe los datos", Toast.LENGTH_SHORT).show();
            }

        });
    }

}