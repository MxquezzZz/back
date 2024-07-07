package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DoctorEntity;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins ="http://localhost:4200")
public class DoctorController {
	  @Autowired
	    private DoctorService doctorService;

	    // Obtener todos los doctores
	    @GetMapping("/all")
	    public ResponseEntity<List<DoctorEntity>> getAllDoctors() {
	        List<DoctorEntity> doctors = doctorService.readAll();
	        return new ResponseEntity<>(doctors, HttpStatus.OK);
	    }

	    // Obtener un doctor por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable int id) {
	        Optional<DoctorEntity> doctor = doctorService.findById(id);
	        return doctor.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
	                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    // Crear un nuevo doctor
	    @PostMapping
	    public ResponseEntity<DoctorEntity> createDoctor(@RequestBody DoctorEntity doctor) {
	    	DoctorEntity nuevoDoctor = doctorService.create(doctor);
	        return new ResponseEntity<>(nuevoDoctor, HttpStatus.CREATED);
	    }

	    // Actualizar un doctor existente
	    @PutMapping("/{id}")
	    public ResponseEntity<DoctorEntity> updateDoctor(@PathVariable int id, @RequestBody DoctorEntity doctor) {
	    	DoctorEntity doctorActualizado = doctorService.update(id, doctor);
	        return doctorActualizado != null ? new ResponseEntity<>(doctorActualizado, HttpStatus.OK)
	                                         : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    // Eliminar un doctor
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDoctor(@PathVariable int id) {
	        doctorService.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
