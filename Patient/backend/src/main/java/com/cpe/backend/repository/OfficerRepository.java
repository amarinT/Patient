package com.cpe.backend.repository;

import com.cpe.backend.entity.Officer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface OfficerRepository extends JpaRepository<Officer, Long> {
	Officer findById(long id);
}