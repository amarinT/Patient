package com.cpe.backend;
  


import com.cpe.backend.entity.Officer;
import com.cpe.backend.entity.BloodType;
import com.cpe.backend.entity.Gender;
import com.cpe.backend.repository.OfficerRepository;
import com.cpe.backend.repository.BloodTypeRepository;
import com.cpe.backend.repository.GenderRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication 
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init( OfficerRepository officerRepository, BloodTypeRepository bloodTypeRepository, GenderRepository genderRepository) {
		return args -> {
			Stream.of("Ticha", "Lalin", "Nisachol", "Neennara").forEach(name -> {
				Officer officer = new Officer(); // สร้าง Object Officer
				officer.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Officer
				officerRepository.save(officer); // บันทึก Objcet ชื่อ Officer
			});

			Stream.of("A", "B", "O","AB").forEach(name -> {
				BloodType bloodType = new BloodType(); // สร้าง Object Blood Type
				bloodType.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Blood Type
				bloodTypeRepository.save(bloodType); // บันทึก Objcet ชื่อ Blood Type
			});

			Stream.of("Male","Female").forEach(genderType -> {
				Gender gender= new Gender(); // สร้าง Object Gender
				gender.setGenderType(genderType); // set ชื่อ (genderType) ให้ Object ชื่อ Gender
				genderRepository.save(gender); // บันทึก Objcet ชื่อ Gender
			});

			
			officerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Officer บน Terminal
			bloodTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity BloodType บน Terminal
			genderRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Gender บน Terminal
		};
	}

}
