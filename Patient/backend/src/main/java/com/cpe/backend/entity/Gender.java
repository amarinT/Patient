package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="GENDER")
public class Gender {

    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gender_seq")  
    @Column(name = "GENDER_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String genderType;


    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "gender"
    private Collection<Patient> register;


	




}
