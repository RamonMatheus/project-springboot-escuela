package com.devrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devrm.entity.Maestro;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro, Long>{
	
	

}
