package com.devrm.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrm.entity.Estudiante;
import com.devrm.service.EstudianteService;
@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	// Actualizar estudiante
	@PutMapping("{id}")
	public ResponseEntity<?> actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id){
		Optional<Estudiante> upestudiante = estudianteService.findEstudianteById(id);
		if(!upestudiante.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		upestudiante.get().setNombre(estudiante.getNombre());
		upestudiante.get().setApellido(estudiante.getApellido());
		upestudiante.get().setDni(estudiante.getDni());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
		
	}
	
	
	//Buscar lista de estudiante
	@GetMapping
	public List<Estudiante> buscarListEstudiantes(){
		List<Estudiante> estudiantes = StreamSupport
				.stream(estudianteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return estudiantes;
	}
	
	// Buscar Estudiante por Id
		@GetMapping("/{id}")
		public ResponseEntity<?> readEstudiante(@PathVariable Long id){
			Optional<Estudiante> oEstudiante = estudianteService.findEstudianteById(id);
			if(!oEstudiante.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(oEstudiante);
		}
	
	// Crear registro de estudiante
		@PostMapping
		public ResponseEntity<?> createEstudiante(@RequestBody Estudiante estudiante){
			return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
		}
	
	// Delete estudiante por Id
		@DeleteMapping("/{id}")
		public ResponseEntity<?> eliminarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id){
			
			if(!estudianteService.findEstudianteById(id).isPresent()) {
				return ResponseEntity.notFound().build();
			}else {
				estudianteService.deleteEstudianteById(id);
				return ResponseEntity.ok().build();
			}
		}
	
	

}
