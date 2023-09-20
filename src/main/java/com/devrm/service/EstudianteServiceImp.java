package com.devrm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devrm.entity.Estudiante;
import com.devrm.repository.EstudianteRepository;

@Service
public class EstudianteServiceImp implements EstudianteService{
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Estudiante> findAll() {
		return estudianteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Estudiante> findAll(Pageable pageable) {
		return estudianteRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Estudiante> findEstudianteById(Long id) {
		return estudianteRepository.findById(id);
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	@Transactional
	public void deleteEstudianteById(Long id) {
		estudianteRepository.deleteById(id);
	}
	
		

}
