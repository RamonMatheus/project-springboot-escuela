package com.devrm.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devrm.entity.Estudiante;

public interface EstudianteService {
	
	public Iterable<Estudiante> findAll();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public Optional<Estudiante> findEstudianteById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void deleteEstudianteById(Long id);
	
	

}
