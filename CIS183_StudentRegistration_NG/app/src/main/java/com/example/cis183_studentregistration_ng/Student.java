package com.example.cis183_studentregistration_ng;

public class Student
{
    private String fname;
    private String lname;
    private String username; // primary key, no id
    private String email;
    private String major; // still need a major reference for the student
    private int age;
    private double gpa;

    public Student()
    {

    }

    public Student(String p_fname, String p_lname, String p_username, String p_email, int p_age, double p_gpa, String p_major)
    {
        fname = p_fname;
        lname = p_lname;
        username = p_username;
        email = p_email;
        age = p_age;
        gpa = p_gpa;
        major = p_major;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
