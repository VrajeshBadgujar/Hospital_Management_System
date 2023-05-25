package com.example.Hospital.management.System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    Map<Integer, Doctor>doctorDb = new HashMap<>();

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){

       int key = doctor.getDoctorId();
       doctorDb.put(key, doctor);
       return "Doctor added successfully";
    }

    @GetMapping("/get")
    public List<Doctor> getAllDoctors(){
        List<Doctor>doctors = new ArrayList<>();

        for (Doctor doctor : doctorDb.values()){
            doctors.add(doctor);
        }
        return doctors;
    }

}
