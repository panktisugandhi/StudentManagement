package com.example.student_management;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Update_Dialog extends AppCompatActivity {

    EditText etname,etcon,etemail,etpass,etbirth,etclg,etgender,ettech,etduration,etsem,etdegree,etprojectname,etgrp1,etgrp2,etguide,etjoin,etend,ettool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_dialog);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogview = inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogview);

        // TextView textView = dialogview.findViewById(R.id.tv_up);
        etname= dialogview.findViewById(R.id.uprtvname);
        etcon= dialogview.findViewById(R.id.uprtvname);
        etemail= dialogview.findViewById(R.id.uprtvname);
        etpass= dialogview.findViewById(R.id.uprtvname);
        etbirth= dialogview.findViewById(R.id.uprtvname);
        etclg= dialogview.findViewById(R.id.uprtvname);
        etgender= dialogview.findViewById(R.id.uprtvname);
        ettech= dialogview.findViewById(R.id.uprtvname);
        etduration= dialogview.findViewById(R.id.uprtvname);
        etsem= dialogview.findViewById(R.id.uprtvname);
        etdegree= dialogview.findViewById(R.id.uprtvname);
        etprojectname= dialogview.findViewById(R.id.uprtvname);
        etgrp1= dialogview.findViewById(R.id.uprtvname);
        etgrp2= dialogview.findViewById(R.id.uprtvname);
        etguide= dialogview.findViewById(R.id.uprtvname);
        etjoin= dialogview.findViewById(R.id.uprtvname);
        etend= dialogview.findViewById(R.id.uprtvname);
        ettool= dialogview.findViewById(R.id.uprtvname);

        dialogBuilder.setTitle("Update Student Detail:");
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }
}
