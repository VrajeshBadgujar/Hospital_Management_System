package com.example.Hospital.management.System;

import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

  NurseService nurseService = new NurseService();

  @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){

    String ans = nurseService.addNurse(nurse);

    return ans;
  }

  @GetMapping("getByAge")
  public List<Nurse> getNursesGreaterThenAge(@RequestParam ("age")Integer age){

    List<Nurse>nursesList = nurseService.getList(age);
    return nursesList;
  }

  @GetMapping("/getByQualification")
  public List<Nurse> getNursesByQualification(@RequestParam("qualification")
                                            String qualification  ){
    List<Nurse>nursesList = nurseService.getNursesByQualification(qualification);

  }

}
