package com.devrm.repository;

import org.springframework.stereotype.Repository;

import com.devrm.entity.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
