package com.example.student_management;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Profile_adapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;
    TextView username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;

    public Profile_adapter(Activity context,List<Student> studentList){
        super(context,R.layout.activity_profile_list,studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listviewItem = inflater.inflate(R.layout.activity_profile_list,null,true);

        username =listviewItem.findViewById(R.id.prtvname);
        contact = listviewItem.findViewById(R.id.prtvcontact);
        email = listviewItem.findViewById(R.id.prtvemail);
        pass = listviewItem.findViewById(R.id.prtvpass);
        birth = listviewItem.findViewById(R.id.prtvbirth);
        clg = listviewItem.findViewById(R.id.prtvclg);
        gender = listviewItem.findViewById(R.id.prtvgender);
        tech = listviewItem.findViewById(R.id.prtvtech);
        duration = listviewItem.findViewById(R.id.prtvduration);
        sem = listviewItem.findViewById(R.id.prtvsem);
        degree = listviewItem.findViewById(R.id.prtvdegree);
        projectname = listviewItem.findViewById(R.id.prtvproname);
        grp1 = listviewItem.findViewById(R.id.prtvgrp1);
        grp2 = listviewItem.findViewById(R.id.prtvgrp2);
        guide = listviewItem.findViewById(R.id.prtvguide);
        join = listviewItem.findViewById(R.id.prtvjoin);
        end = listviewItem.findViewById(R.id.prtvend);
        tool = listviewItem.findViewById(R.id.prtvtool);

        Student student = studentList.get(position);
        username.setText(student.getUsername());
        contact.setText(student.getContact());
        email.setText(student.getEmail());
        pass.setText(student.getPass());
        birth.setText(student.getBirth());
        clg.setText(student.getClg());
        gender.setText(student.getGender());
        tech.setText(student.getTech());
        duration.setText(student.getDuration());
        sem.setText(student.getSem());
        degree.setText(student.getDegree());
        projectname.setText(student.getProjectname());
        grp1.setText(student.getGrp1());
        grp2.setText(student.getGrp2());
        guide.setText(student.getGuide());
        join.setText(student.getJoin());
        end.setText(student.getEnd());
        tool.setText(student.getTool());

        return listviewItem;
    }
}
