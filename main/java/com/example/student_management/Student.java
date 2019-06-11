package com.example.student_management;

public class Student {
   public String username,contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;

   public Student(){

   }
    public Student(String username, String contact, String email,String pass, String birth, String clg, String gender, String tech, String duration,String sem,String degree,String projectname,String grp1,String grp2,String guide,String join,String end,String tool) {
        this.username = username;
        this.contact = contact;
        this.email = email;
        this.pass = pass;
        this.birth = birth;
        this.clg = clg;
        this.gender = gender;
        this.tech = tech;
        this.duration = duration;
        this.sem = sem;
        this.degree = degree;
        this.projectname = projectname;
        this.grp1 = grp1;
        this.grp2 = grp2;
        this.guide = guide;
        this.join = join;
        this.end = end;
        this.tool = tool;
    }
}
