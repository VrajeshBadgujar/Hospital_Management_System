package com.example.Hospital.management.System;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private int age;
    private String degree;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Doctor(int doctorId, String name, String specialization, int age) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.age = age;
    }
}
