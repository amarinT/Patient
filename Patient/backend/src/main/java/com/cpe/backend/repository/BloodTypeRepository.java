package com.cpe.backend.repository;

import com.cpe.backend.entity.BloodType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
	BloodType findById(long id);
}