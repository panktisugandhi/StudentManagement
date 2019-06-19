package com.example.student_management;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forgotpass extends AppCompatActivity {

    ProgressBar progressBar;
    EditText useremail,new_pass;
    Button btn_send,btn_cancle;
    FirebaseUser user ;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);


        progressBar = findViewById(R.id.progresbar);
        useremail = findViewById(R.id.et_forgot_email);
        //new_pass = findViewById(R.id.et_forgot_pass);
        btn_send = findViewById(R.id.btnsend);
        user = FirebaseAuth.getInstance().getCurrentUser();


        firebaseAuth = FirebaseAuth.getInstance();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                progressBar.setVisibility(v.VISIBLE);
              //  String username = useremail.getText().toString().trim();
//                final String pass = new_pass.getText().toString().trim();
//                final AuthCredential credential = EmailAuthProvider.getCredential("nirpa@gmail.com","25802580");
//
//                if (useremail.equals("")){
//                    Toast.makeText(Forgotpass.this, "Plz Enter Email..", Toast.LENGTH_SHORT).show();
//                }else {
//                    user.reauthenticate(credential)
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        user.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//                                                if (task.isSuccessful()) {
//                                                    Toast.makeText(Forgotpass.this, "Password updated", Toast.LENGTH_SHORT).show();
//                                                    //Log.d(TAG, "Password updated");
//                                                } else {
//                                                    Toast.makeText(Forgotpass.this, "Error password not updated", Toast.LENGTH_SHORT).show();
//                                                    //Log.d(TAG, "Error password not updated")
//                                                }
//                                            }
//                                        });
//                                    }else {
//                                        Toast.makeText(Forgotpass.this, "Error auth failed", Toast.LENGTH_SHORT).show();
//                                        //Log.d(TAG, "Error auth failed")
//                                    }
//                                }
//                            });
                firebaseAuth.sendPasswordResetEmail(useremail.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(v.GONE);
                        if (task.isSuccessful()){
                            Toast.makeText(Forgotpass.this, "PassWord Send To your Email..", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Forgotpass.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
