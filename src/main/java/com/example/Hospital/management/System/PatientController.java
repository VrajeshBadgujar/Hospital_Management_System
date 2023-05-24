package com.example.Hospital.management.System;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

     HashMap<Integer, Patient>patientDb = new HashMap<>();

     @PostMapping("/addPatientViaParameters")
     public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                              @RequestParam("age")Integer age, @RequestParam("disease")String disease){

//          System.out.println("post method called");
          Patient patient = new Patient(patientId, name, age, disease);
          patientDb.put(patientId, patient);
          return "Patient added";
     }

     @PostMapping("/addPatientViaRequestBody")
     public String addPatient(@RequestBody Patient patient){

          int key = patient.getPatientId();
          patientDb.put(key, patient);
          return "patient added successfully";
     }


@GetMapping("/getPatientInfo")
     public Patient getPatient(@RequestParam ("patientId")Integer patientId){
//          System.out.println("name of patient is" + patientDb.get(patientId).getName());

          return patientDb.get(patientId);
}

@GetMapping("/getAllPatients")
     public List<Patient> getAllPatients(){

     List<Patient> patients = new ArrayList<>();

     for (Patient p : patientDb.values()){
          patients.add(p);
     }

      return patients;
}

@GetMapping("/getPatientByName")
     public Patient getPatientByName(@RequestParam ("name")String  name){

        for (Patient p : patientDb.values()){
             if(p.getName().equals(name))
                  return p;
        }

          return null;
}

@GetMapping("/getPatientListGreaterThanAge")
     public List<Patient>getPatientListGreaterThenAge (@RequestParam("age")Integer age){
     List<Patient>patients = new ArrayList<>();

     for (Patient p : patientDb.values()){
          if(p.getAge() > age){
               patients.add(p);
          }
     }
     return patients;
}

//

}
