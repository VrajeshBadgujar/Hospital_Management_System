package com.example.Hospital.management.System;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@RestController
public class PatientController {

     HashMap<Integer,Patient>patientDb = new HashMap<>();

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

     @GetMapping("/getPatientInfoViapathVariable/{patientId}")
     public Patient getPatientInfo(@PathVariable ("patientId")Integer
                                   patientId){

         return patientDb.get(patientId);
     }

     @GetMapping("/getPatient/{age}/{disease}")
     public List<Patient> getPatients(@PathVariable ("age")Integer age, @PathVariable("disease")String disease){

         List<Patient>patients = new ArrayList<>();

         for (Patient p : patientDb.values()){
             if(p.getAge() > age && p.getDisease().equals(disease)){
                 patients.add(p);
             }
         }
//         System.out.println("add patients");
         return patients;
     }


@GetMapping("/getPatientInfo")
     public Patient getPatient(@RequestParam ("patientId")Integer patientId){
//         System.out.println("name of patient is" + patientDb.get(patientId).getName());

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

//we can use any data structure
@GetMapping("/getPatientListGreaterByAge")
     public Stack<Patient>getPatientListGreaterByAge (@RequestParam("age")Integer age){
     Stack<Patient>st = new Stack<>();

     for (Patient p : patientDb.values()){
          if(p.getAge() > age){
               st.add(p);
          }
     }
     return st;
}

@PutMapping("/updateDisease")
public String updateDisease(@RequestParam("patientId")Integer patientId, @RequestParam("disease")String disease){

    if(patientDb.containsKey(patientId)){

       Patient patient = patientDb.get(patientId);
       patient.setDisease(disease);

       patientDb.put(patientId, patient);
       return "Patient updated successfully";
    }
         return "PatientID doesn't exist";
}


@PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody Patient patient){

     int key = patient.getPatientId();

     if(patientDb.containsKey(key)){
         patientDb.put(key, patient);
         return "Patient added successfully";
     }
     return "Patient does not found ";
}

@DeleteMapping("/deletePatient")
    public String deletePatient (@RequestParam ("patientId")Integer patientId){

     patientDb.remove(patientId);
     return "Patient deleted successfully";

}


}
