package com.example.student_management;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

   public ListView liststudent;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseStudent;

    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseStudent = FirebaseDatabase.getInstance().getReference().child("Student");
        liststudent = findViewById(R.id.student_listview);
        studentList = new ArrayList<>();

        liststudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {

                Student student = studentList.get(i);
                ShowUpdateDialog(student.getUsername()
                        ,student.getContact()
                        ,student.getEmail()
                        ,student.getPass()
                        ,student.getBirth()
                        ,student.getClg()
                        ,student.getGender()
                        ,student.getTech()
                        ,student.getDuration()
                        ,student.getSem()
                        ,student.getDegree()
                        ,student.getProjectname()
                        ,student.getGrp1()
                        ,student.getGrp2()
                        ,student.getGuide()
                        ,student.getJoin()
                        ,student.getEnd()
                        ,student.tool);

                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseStudent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot studentsnapshot : dataSnapshot.getChildren()){
                    Student student = studentsnapshot.getValue(Student.class);
                    studentList.add(student);

                }
                Profile_adapter profile_adapter = new Profile_adapter(ProfileActivity.this,studentList);
                liststudent.setAdapter(profile_adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ShowUpdateDialog(String username, String contact, String email,String pass, String birth, String clg, String gender, String tech, String duration,String sem,String degree,String projectname,String grp1,String grp2,String guide,String join,String end,String tool ){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogview = inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogview);

       // TextView textView = dialogview.findViewById(R.id.tv_up);
        final EditText etname= dialogview.findViewById(R.id.uprtvname);
        final EditText etcon= dialogview.findViewById(R.id.uprtvcontact);
        final EditText etemail= dialogview.findViewById(R.id.uprtvemail);
        final EditText etpass= dialogview.findViewById(R.id.uprtvpass);
        final EditText etbirth= dialogview.findViewById(R.id.uprtvbirth);
        final EditText etclg= dialogview.findViewById(R.id.uprtvclg);
        final EditText etgender= dialogview.findViewById(R.id.uprtvgender);
        final EditText ettech= dialogview.findViewById(R.id.uprtvtech);
        final EditText etduration= dialogview.findViewById(R.id.uprtvduration);
        final EditText etsem= dialogview.findViewById(R.id.uprtvsem);
        final EditText etdegree= dialogview.findViewById(R.id.uprtvdegree);
        final EditText etproname= dialogview.findViewById(R.id.uprtvproname);
        final EditText etgrp1= dialogview.findViewById(R.id.uprtvgrp1);
        final EditText etgrp2= dialogview.findViewById(R.id.uprtvgrp2);
        final EditText etguide= dialogview.findViewById(R.id.uprtvguide);
        final EditText etjoin= dialogview.findViewById(R.id.uprtvjoin);
        final EditText etend= dialogview.findViewById(R.id.uprtvend);
        final EditText ettool= dialogview.findViewById(R.id.uprtvtool);

        Button btn_update = dialogview.findViewById(R.id.btn_up_update);
        dialogBuilder.setTitle("Update Student  "+username);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etname.getText().toString().trim();
                String contact = etcon.getText().toString().trim();
                String email = etemail.getText().toString().trim();
                String pass = etpass.getText().toString().trim();
                String birth = etbirth.getText().toString().trim();
                String clg = etclg.getText().toString().trim();
                String gender = etgender.getText().toString().trim();
                String tech = ettech.getText().toString().trim();
                String duration = etduration.getText().toString().trim();
                String sem = etsem.getText().toString().trim();
                String degree = etdegree.getText().toString().trim();
                String peojectname = etproname.getText().toString().trim();
                String grp1 = etgrp1.getText().toString().trim();
                String grp2 = etgrp2.getText().toString().trim();
                String guide = etguide.getText().toString().trim();
                String join = etjoin.getText().toString().trim();
                String end = etend.getText().toString().trim();
                String tool = ettool.getText().toString().trim();

                updatestudent(username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,peojectname,grp1,grp2,guide,join,end,tool);
                alertDialog.dismiss();
            }
        });

    }
    private boolean updatestudent(String username, String contact, String email,String pass, String birth, String clg, String gender, String tech, String duration,String sem,String degree,String projectname,String grp1,String grp2,String guide,String join,String end,String tool ){


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").child(firebaseAuth.getUid());
        Student student = new Student(username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool);
        databaseReference.setValue(student);
        Toast.makeText(this, "DATA Updated..", Toast.LENGTH_SHORT).show();

    return true;
    }
}
//        TextView username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;
//
//        FirebaseAuth firebaseAuth;
//        DatabaseReference databaseReference;
//
//        username = findViewById(R.id.prtvname);
//        contact = findViewById(R.id.prtvcontact);
//        email = findViewById(R.id.prtvemail);
//        pass = findViewById(R.id.prtvpass);
//        birth = findViewById(R.id.prtvbirth);
//        clg = findViewById(R.id.prtvclg);
//        gender = findViewById(R.id.prtvgender);
//        tech = findViewById(R.id.prtvtech);
//        duration = findViewById(R.id.prtvduration);
//        sem = findViewById(R.id.prtvsem);
//        degree = findViewById(R.id.prtvdegree);
//        projectname = findViewById(R.id.prtvproname);
//        grp1 = findViewById(R.id.prtvgrp1);
//        grp2 = findViewById(R.id.prtvgrp2);
//        guide = findViewById(R.id.prtvguide);
//        join = findViewById(R.id.prtvjoin);
//        end = findViewById(R.id.prtvend);
//        tool = findViewById(R.id.prtvtool);
//
//
//
//        firebaseAuth = FirebaseAuth.getInstance();
//     //   firebaseUser = firebaseAuth.getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").child(firebaseAuth.getUid());
//
//
//
//        // databaseReference = firebaseDatabase.getReference("Student"+firebaseAuth.getUid());
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//               if(dataSnapshot.exists())
//                {
//                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
//                    {
//                        Student user = dataSnapshot.getValue(Student.class);
//                        username.setText(user.getUsername());
//                        contact.setText(user.getContact());
//                        email.setText(user.getEmail());
//                        pass.setText(user.getPass());
//                        birth.setText(user.getBirth());
//                        clg.setText(user.getClg());
//                        gender.setText(user.getGender());
//                        tech.setText(user.getTech());
//                        duration.setText(user.getDuration());
//                        sem.setText(user.getSem());
//                        degree.setText(user.getDegree());
//                        projectname.setText(user.getProjectname());
//                        grp1.setText(user.getGrp1());
//                        grp2.setText(user.getGrp2());
//                        guide.setText(user.getGuide());
//                        join.setText(user.getJoin());
//                        end.setText(user.getEnd());
//                        tool.setText(user.getTool());
//
//                    }
//                }
//
//               // Toast.makeText(ProfileActivity.this, firebaseAuth.getUid(), Toast.LENGTH_SHORT).show();
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                Toast.makeText(ProfileActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    public void ShowUpdateDialog(String username, String contact, String email,String pass, String birth, String clg, String gender, String tech, String duration,String sem,String degree,String projectname,String grp1,String grp2,String guide,String join,String end,String tool ){
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogview = inflater.inflate(R.layout.update_dialog,null);
//        dialogBuilder.setView(dialogview);
//
//       // TextView textView = dialogview.findViewById(R.id.tv_up);
//        EditText etname= dialogview.findViewById(R.id.uprtvname);
//        EditText etcon= dialogview.findViewById(R.id.uprtvname);
//        EditText etemail= dialogview.findViewById(R.id.uprtvname);
//        EditText etpass= dialogview.findViewById(R.id.uprtvname);
//        EditText etbirth= dialogview.findViewById(R.id.uprtvname);
//        EditText etclg= dialogview.findViewById(R.id.uprtvname);
//        EditText etgender= dialogview.findViewById(R.id.uprtvname);
//        EditText ettech= dialogview.findViewById(R.id.uprtvname);
//        EditText etduration= dialogview.findViewById(R.id.uprtvname);
//        EditText etsem= dialogview.findViewById(R.id.uprtvname);
//        EditText etdegree= dialogview.findViewById(R.id.uprtvname);
//        EditText etproname= dialogview.findViewById(R.id.uprtvname);
//        EditText etgrp1= dialogview.findViewById(R.id.uprtvname);
//        EditText etgrp2= dialogview.findViewById(R.id.uprtvname);
//        EditText etguide= dialogview.findViewById(R.id.uprtvname);
//        EditText etjoin= dialogview.findViewById(R.id.uprtvname);
//        EditText etend= dialogview.findViewById(R.id.uprtvname);
//        EditText ettool= dialogview.findViewById(R.id.uprtvname);
//
//        Button btn_update = dialogview.findViewById(R.id.btn_up_update);
//        dialogBuilder.setTitle("Update Student"+username);
//
//        AlertDialog alertDialog = dialogBuilder.create();
//        alertDialog.show();
//
//    }
//}
