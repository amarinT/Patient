package com.cpe.backend.controller;
 

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.entity.Officer;
import com.cpe.backend.entity.BloodType;
import com.cpe.backend.entity.Gender;
import com.cpe.backend.entity.Patient;
import com.cpe.backend.repository.OfficerRepository;
import com.cpe.backend.repository.BloodTypeRepository;
import com.cpe.backend.repository.PatientRepository;
import com.cpe.backend.repository.GenderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController     //@RestController ทำให้  class PatientController  เป็น Controller
public class PatientController {
    @Autowired    //เป็นการดึงหรือเป็นการเข้าถึง หรือเรียก  PatientRepository เข้ามาใช้อัตโนมัติเมื่อมีการรัน
    private final PatientRepository patientRepository;      //สร้าง Object ชื่อ patientRepository ชนิด PatientRepository เพื่อใช้งาน Entity Patient
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private OfficerRepository officerRepository;
    @Autowired  
    private BloodTypeRepository bloodTypeRepository;   

    PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
  
    @GetMapping("/patient")  
    public Collection<Patient> Patients() {
        return patientRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @PostMapping("/patient/{patientName}/{identityId}/{gender_id}/{age_id}/{bloodType_id}/{officer_id}")
    public Patient newPatient(Patient newPatient,
    @PathVariable long officer_id, 
    @PathVariable long gender_id,
    @PathVariable long bloodType_id,
    @PathVariable String patientName,
    @PathVariable String identityId, 
    @PathVariable Integer age_id) {
    

   
    Gender gender = genderRepository.findById(gender_id);              //ค้นหาข้อมูลใน Gender โดยใช้ id
    Officer createdBy = officerRepository.findById(officer_id);        //ค้นหาข้อมูลใน Officer โดยใช้ id
    BloodType bloodType = bloodTypeRepository.findById(bloodType_id);  //ค้นหาข้อมูลใน BloodType โดยใช้ id
   


    
    newPatient.setCreatedBy(createdBy);
    newPatient.setPatientName(patientName);
    newPatient.setIdentityId(identityId);
    newPatient.setGender(gender);
    newPatient.setAge(age_id); 
    newPatient.setBloodType(bloodType);
    newPatient.setRegisterDate(new Date());

    return patientRepository.save(newPatient); //บันทึก Objcet ชื่อ Patient
    
    }
}