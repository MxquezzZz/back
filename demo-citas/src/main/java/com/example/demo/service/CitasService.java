package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Citas;

public interface CitasService  {

	List<Citas> readlAll();
	Citas create(Citas citas);
	Citas update(Citas citas);
	void delete (int id);
	Optional<Citas> findById(int id);
}
