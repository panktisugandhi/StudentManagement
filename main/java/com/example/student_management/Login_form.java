package com.example.student_management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_form extends AppCompatActivity {

    EditText et_email,et_pass;
    Button btn_login;
    TextView tv_forgot;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);

        et_email = findViewById(R.id.et_email1);
        et_pass = findViewById(R.id.et_pass1);
        btn_login = findViewById(R.id.btn_log);
        tv_forgot  = findViewById(R.id.tv_forgot);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login_form.this, "Pls Enter Email..", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass))
                {
                    Toast.makeText(Login_form.this, "Pls Enter password..", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length()<6)
                {
                    Toast.makeText(Login_form.this, "Your Password Must Be Grater Then 6 Digit!!!!", Toast.LENGTH_SHORT).show();
                }

                firebaseAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Login_form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(Login_form.this, ProfileActivity.class));
                                    Toast.makeText(Login_form.this, "Login Successfully....", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Login_form.this, "Login Failed or User not Available ", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_form.this, Forgotpass.class));
            }
        });
    }

    public void btn_signupFoam(View view) {
        startActivity(new Intent(Login_form.this, NocStatus.class));
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
