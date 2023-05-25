package com.example.Hospital.management.System;

public class Nurse {

    private int nurseId;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setNamr(String namr) {
        this.name = namr;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String qualification;
    private int age;

    public Nurse(int nurseId, String namr, String qualification, int age) {
        this.nurseId = nurseId;
        this.name = namr;
        this.qualification = qualification;
        this.age = age;
    }
}
