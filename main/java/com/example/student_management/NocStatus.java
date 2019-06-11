package com.example.student_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NocStatus extends AppCompatActivity {

    Button btn_no,btn_yes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noc_status);

        btn_no = findViewById(R.id.btn_no);
        btn_yes = findViewById(R.id.btn_yes);

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NocStatus.this, "If You Can Do Registration Then You Must N.O.C status Yes!!!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NocStatus.this,Sign_up.class));
            }
        });
    }
}
