package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="OFFICER") //สร้าง Table ชื่อ OFFICER
public class Officer {
    @Id
    @SequenceGenerator(name="OFFICER_SEQ",sequenceName="OFFICER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OFFICER_SEQ")
    @Column(name="OFFICER_ID",unique = true, nullable = true)       //สร้าง column ชื่อ OFFICER_ID
    private @NonNull Long id;

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER) // map กับ Patient ด้วย One To Many
    // mappedBy  = "createdBy"
    private Collection<Patient> register;

	
}