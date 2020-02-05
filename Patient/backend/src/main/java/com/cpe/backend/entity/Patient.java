package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cpe.backend.entity.Officer;;

@Data
@Entity        // @Entity ทำให้ public class Patient เป็น Entity
@NoArgsConstructor
@Table(name="PATIENT")
public class Patient {

    @Id         //กำหนดให้ Long id เป็น Primary Key
    @SequenceGenerator(name="patient_seq",sequenceName="patient_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patient_seq") //@GeneratedValue ทำให้ id รันเลขไปอัตโนมัติ

    
    @Column(name = "PATIENT_ID", unique = true, nullable = true) //สร้าง column ขื่อ PATIENT_ID
    private @NonNull Long id;

    @Column(name="PATIENT_NAME")                 //สร้าง column ขื่อ PATIENT_NAME
    private @NonNull String patientName;

    @Column(name="IDENTIFICATION_NUMBER")    // แก้ datatype IdentityId  เป็น String 
    private @NonNull String identityId;

    @Column(name="AGE")                     
    private @NonNull Integer age;

    @Column(name="REGISTER_DATE")           
    private @NonNull Date registerDate;


    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Officer.class)
    @JoinColumn(name = "OFFICER_ID", insertable = true)
    private Officer createdBy;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private Gender gender;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BloodType.class)
    @JoinColumn(name = "BLOODL_TYPE_ID", insertable = true)
    private BloodType bloodType;
	
    
	
}