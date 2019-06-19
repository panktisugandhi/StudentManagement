package com.example.student_management;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_up extends AppCompatActivity {

    EditText et_user,et_contact,et_email,et_pass,et_birth,et_clg,et_projectname,et_grp1,et_grp2,et_guide,et_join,et_end;
    Spinner sp_tech,sp_duration,sp_sem,sp_degree;
    RadioButton r_male,r_female,r_bisag,r_laptop;
    String gender="";
    String tool="";
    Button btn_reg;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        et_user = findViewById(R.id.et_user);
        et_contact = findViewById(R.id.et_contact);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        et_birth = findViewById(R.id.et_birth);
        et_clg = findViewById(R.id.et_clg);
        et_projectname = findViewById(R.id.et_projectname);
        et_grp1 = findViewById(R.id.et_grp1);
        et_grp2 = findViewById(R.id.et_grp2);
        et_guide = findViewById(R.id.et_guide);
        et_join = findViewById(R.id.et_joining);
        et_end = findViewById(R.id.et_ending);
        sp_tech = findViewById(R.id.sp_tech);
        sp_duration = findViewById(R.id.sp_duration);
        sp_sem = findViewById(R.id.sp_sem);
        sp_degree = findViewById(R.id.sp_degree);
        r_male = findViewById(R.id.r_male);
        r_female = findViewById(R.id.r_female);
        r_bisag = findViewById(R.id.r_BISAG);
        r_laptop = findViewById(R.id.r_LAPTOP);
        btn_reg = findViewById(R.id.btn_reg);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Student");
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username =et_user.getText().toString();
                final String  contact = et_contact.getText().toString();
                final String  email = et_email.getText().toString();
                final String  pass = et_pass.getText().toString();
                final String  birth = et_birth.getText().toString();
                final String  clg = et_clg.getText().toString();
                final String  tech = sp_tech.getSelectedItem().toString();
                final String  duration = sp_duration.getSelectedItem().toString();
                final String  sem = sp_sem.getSelectedItem().toString();
                final String  degree = sp_degree.getSelectedItem().toString();
                final String  projectname = et_projectname.getText().toString();
                final String  grp1 = et_grp1.getText().toString();
                final String  grp2 = et_grp2.getText().toString();
                final String  guide = et_guide.getText().toString();
                final String  join = et_join.getText().toString();
                final String  end = et_end.getText().toString();


                if (username.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Username..", Toast.LENGTH_SHORT).show();
                }
                if (contact.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Contact Number..", Toast.LENGTH_SHORT).show();
                }
                if (contact.length()<=9){
                    Toast.makeText(Sign_up.this, "Enter Correct Contact Number..", Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Email..", Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Password..", Toast.LENGTH_SHORT).show();
                }
                if (pass.length()<=6){
                    Toast.makeText(Sign_up.this, "Enter Grater Then 6 Digit Password..", Toast.LENGTH_SHORT).show();
                }
                if (birth.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter BirthDate..", Toast.LENGTH_SHORT).show();
                }
                if (clg.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter College Name..", Toast.LENGTH_SHORT).show();
                }
//                if (gender.isEmpty()){
//                    Toast.makeText(Sign_up.this, "Select Gender..", Toast.LENGTH_SHORT).show();
//                }
                if (tech.isEmpty()){
                    Toast.makeText(Sign_up.this, "Select Technology..", Toast.LENGTH_SHORT).show();
                }
                if (duration.isEmpty()){
                    Toast.makeText(Sign_up.this, "Select Duration..", Toast.LENGTH_SHORT).show();
                }
                if (sem.isEmpty()){
                    Toast.makeText(Sign_up.this, "Select Semester..", Toast.LENGTH_SHORT).show();
                }
                if (degree.isEmpty()){
                    Toast.makeText(Sign_up.this, "Select Degree..", Toast.LENGTH_SHORT).show();
                }
                if (projectname.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter ProjectName..", Toast.LENGTH_SHORT).show();
                }
                if (guide.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter GuideName..", Toast.LENGTH_SHORT).show();
                }
                if (join.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Joining Date..", Toast.LENGTH_SHORT).show();
                }
                if (end.isEmpty()){
                    Toast.makeText(Sign_up.this, "Enter Ending Date..", Toast.LENGTH_SHORT).show();
                }
//                if (tool.isEmpty()){
//                    Toast.makeText(Sign_up.this, "Select Tool..", Toast.LENGTH_SHORT).show();
//                }
                if (r_male.isChecked()){
                    gender="MALE";
                }
                if (r_female.isChecked()){
                    gender="FEMALE";
                }
                if (r_bisag.isChecked()){
                    tool = "BISAG PC";
                }
                if (r_laptop.isChecked()){
                    tool = "LAPTOP";
                }
                firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {


                                    Student stu = new Student(
                                            username,
                                            contact,
                                            email,
                                            pass,
                                            birth,
                                            clg,
                                            gender,
                                            tech,
                                            duration,
                                            sem,
                                            degree,
                                            projectname,
                                            grp1,
                                            grp2,
                                            guide,
                                            join,
                                            end,
                                            tool
                                    );

                                    FirebaseDatabase.getInstance().getReference("Student")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(stu).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {


                                           // firebaseAuth.signOut();
                                            Toast.makeText(Sign_up.this, "Registration successfully....", Toast.LENGTH_SHORT).show();
                                            finish();
                                            startActivity(new Intent(Sign_up.this,GroupId.class));
                                        }
                                    });


                                } else {

                                    Toast.makeText(Sign_up.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
                                }

                                // ...
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
