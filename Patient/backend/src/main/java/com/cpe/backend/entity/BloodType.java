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
@Table(name="BLOOD_TYPE")
public class BloodType {
    @Id
    @SequenceGenerator(name="BLOOD_TYPE_SEQ",sequenceName="BLOOD_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BLOOD_TYPE_SEQ")
    @Column(name="BLOOD_TYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER)
    //mappedBy  = "bloodType"
    private Collection<Patient> register;

	
}