package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DoctorEntity;
public interface DoctorService {
	 List<DoctorEntity> readAll();
	    Optional<DoctorEntity> findById(int id);
	    DoctorEntity create(DoctorEntity doctor);
	    DoctorEntity update(int id, DoctorEntity doctor);
	    void delete(int id);
}
