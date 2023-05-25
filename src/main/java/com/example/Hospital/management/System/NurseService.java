package com.example.Hospital.management.System;

import org.springframework.stereotype.Service;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepositary nurseRepositary = new NurseRepositary();
    public String addNurse(Nurse nurse) {

        if(nurse.getNurseId() < 0)
            return "Enter a valid NurseId";

        if(nurse.getName().equals(null))
            return "Name can not be null";

       String ans = nurseRepositary.addNurse(nurse);

       return ans;
    }

    public List<Nurse>getList(int age){

     List<Nurse>nurses = nurseRepositary.getAllNurses();
     List<Nurse>list = new ArrayList<>();

     for(Nurse nurse : nurses){
         if(nurse.getAge() > age){
             list.add(nurse);
         }
     }
      return list;
    }

    public List<Nurse> getNursesByQualification(String qualification) {

      List<Nurse>nurses = nurseRepositary.getAllNurses();

      List<Nurse>list = new ArrayList<>();

      for (Nurse nurse : nurses){
          if(nurse.getQualification().equals(qualification))
              list.add(nurse);
      }
        return list;
    }
}
