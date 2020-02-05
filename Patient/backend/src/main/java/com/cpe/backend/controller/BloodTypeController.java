package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.entity.BloodType;
import com.cpe.backend.repository.BloodTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BloodTypeController {  

    @Autowired
    private final BloodTypeRepository bloodTypeRepository;

    public BloodTypeController(BloodTypeRepository bloodTypeRepository) {
        this.bloodTypeRepository = bloodTypeRepository;
    }

    @GetMapping("/bloodType")
    public Collection<BloodType> BloodTypes() {
        return bloodTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}
