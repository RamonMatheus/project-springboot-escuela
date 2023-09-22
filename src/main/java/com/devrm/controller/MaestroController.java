package com.devrm.controller;

import java.util.List;
import java.util.Optional;

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

import com.devrm.entity.Maestro;
import com.devrm.service.MaestroService;

@RestController
@RequestMapping("/api/v1/maestros")
public class MaestroController {
	
	@Autowired
	private MaestroService maestroService;
	
	// Obtiene la lista de todos los maestros
	@GetMapping
	public List<Maestro> obtenerMaestros(){
		return maestroService.obtenerMaestros();
	}
	
	// Obtener maestro por Id
	@GetMapping("{id}")
	public ResponseEntity<?> obtenerMaestroPorId(@PathVariable Long id){
		Optional<Maestro> oMaestro = maestroService.obtenerMaestroPorId(id);
		if(!oMaestro.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oMaestro);
	}
	
	// Guardar un maestro nuevo
	@PostMapping
	public ResponseEntity<?> guardarMaestro(@RequestBody Maestro maestro){
		return ResponseEntity.status(HttpStatus.CREATED).body(maestroService.guardarMaestro(maestro));
	}
	
	// Editar un registro de maestro
	@PutMapping("{id}")
	public ResponseEntity<?> actualizarMaestroPorId(@RequestBody Maestro maestro, @PathVariable Long id){
		Optional<Maestro> actMaestro = maestroService.obtenerMaestroPorId(id);
		if(!actMaestro.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		actMaestro.get().setNombre(maestro.getNombre());
		actMaestro.get().setApellido(maestro.getApellido());
		actMaestro.get().setDni(maestro.getDni());
		actMaestro.get().setEmail(maestro.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(maestroService.guardarMaestro(actMaestro.get()));
		
	}
	
	//Eliminar Maestro
	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminarMaestroPorId(@RequestBody Maestro maestro, @PathVariable Long id){
		if(!maestroService.obtenerMaestroPorId(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			maestroService.eliminarMaestroPorId(id);
			return ResponseEntity.ok().build();
		}
	}
	
	

}
