package com.cpe.backend.repository;

import com.cpe.backend.entity.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PatientRepository extends JpaRepository<Patient, Long> { // ผูก Entity Patient ซึ่ง Primary key ใน class Patient เป็น Long
}