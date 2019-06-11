package com.example.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GroupId extends AppCompatActivity {

    TextView tv_id;
    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Button btn_goto_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_id);
        tv_id = findViewById(R.id.tv_rendom);
        btn_goto_login = findViewById(R.id.go_login);
        Random r = new Random();
        //  Random rnd = new Random();
        char randomChar = alphabet.charAt(r.nextInt(alphabet.length()));
        Log.i("myapp", "Thread ID is " + Thread.currentThread().getId() + ", Random character is " + randomChar);
        String generatedPassword = String.format("%06d", r.nextInt(1000000));
        Log.d("MyApp", "Generated Password : " + generatedPassword);

        tv_id.setText(randomChar + "" + generatedPassword);

        btn_goto_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupId.this,Login_form.class));
            }
        });
    }

}
