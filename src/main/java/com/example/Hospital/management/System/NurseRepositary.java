package com.example.Hospital.management.System;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NurseRepositary {

    Map<Integer, Nurse>nurseDb = new HashMap<>();
    public String addNurse(Nurse nurse) {

      int key = nurse.getNurseId();;
      nurseDb.put(key, nurse);

      return "Nurse added successfully";
    }

   public List<Nurse> getAllNurses(){

        return nurseDb.values().stream().toList();
   }
}
