package com.devrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrm.entity.Maestro;
import com.devrm.repository.MaestroRepository;

@Service
public class MaestroServiceImp implements MaestroService {
	
	@Autowired
	private MaestroRepository maestroRepository;
	
	// Obtener lista de maestros
	public List<Maestro> obtenerMaestros(){
		return maestroRepository.findAll();
	}
	
	// Obtener maestro por Id
	public Optional<Maestro> obtenerMaestroPorId(Long id){
		return maestroRepository.findById(id);
	}
	
	// Guardar o editar maestro
	public Maestro guardarMaestro(Maestro maestro) {
		return maestroRepository.save(maestro);
	}
	
	// Eliminar Maestro
	public void eliminarMaestroPorId(Long id) {
		maestroRepository.deleteById(id);
	}
}
