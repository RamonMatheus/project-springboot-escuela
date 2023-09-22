package com.devrm.service;

import java.util.List;
import java.util.Optional;

import com.devrm.entity.Maestro;

public interface MaestroService {
	
	public List<Maestro> obtenerMaestros();
	
	public Optional<Maestro> obtenerMaestroPorId(Long id);
	
	public Maestro guardarMaestro(Maestro maestro);
	
	public void eliminarMaestroPorId(Long id);

}
