package com.example.cis183_studentregistration_ng;

public class Major
{
    private String majorName;
    private String majorPrefix; // like CIS, BUS, CYB, and others.
    private int majorId; //p-key

    public Major()
    {

    }

    // non database constructor
    // forgot you can have as many constructors as needed because they're just overloaded, this helps alot
    public Major(String p_majorName, String p_majorPrefix)
    {
        majorName = p_majorName;
        majorPrefix = p_majorPrefix;
    }

    // database constructor
    public Major(int p_majorId, String p_majorName, String p_majorPrefix)
    {
        majorName = p_majorName;
        majorPrefix = p_majorPrefix;
        majorId = p_majorId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorPrefix() {
        return majorPrefix;
    }

    public void setMajorPrefix(String majorPrefix) {
        this.majorPrefix = majorPrefix;
    }
}
