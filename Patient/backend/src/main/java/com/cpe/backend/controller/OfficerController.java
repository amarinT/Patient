package com.cpe.backend.controller;

import com.cpe.backend.entity.Officer;
import com.cpe.backend.repository.OfficerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OfficerController {

    @Autowired
    private final OfficerRepository officerRepository;

    public OfficerController(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    @GetMapping("/officer")
    public Collection<Officer> Officers() {
        return officerRepository.findAll().stream().collect(Collectors.toList());
    }

}