package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_doctor;
	private String nombre;
	private String apellidos;
		
	public Doctor() {
		super();
	}

	public Doctor(int id_doctor, String nombre, String apellidos) {
		super();
		this.id_doctor = id_doctor;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	
	
}
