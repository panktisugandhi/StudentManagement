package com.example.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {

    EditText et_email,et_pass;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        et_email = findViewById(R.id.et_Ad_email);
        et_pass = findViewById(R.id.et_Ad_pass);
        btn_login = findViewById(R.id.btn_Ad_log);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_email.getText().toString().equals("admin") && et_pass.getText().toString().equals("123")) {
                    Toast.makeText(Admin_login.this, "Login Successfully...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Admin_login.this,SearchScreen.class));
                } else {
                    Toast.makeText(Admin_login.this, "Login Failed...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
