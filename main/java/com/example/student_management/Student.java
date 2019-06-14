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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getGrp1() {
        return grp1;
    }

    public void setGrp1(String grp1) {
        this.grp1 = grp1;
    }

    public String getGrp2() {
        return grp2;
    }

    public void setGrp2(String grp2) {
        this.grp2 = grp2;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
