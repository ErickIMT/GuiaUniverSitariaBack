package com.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.modelo.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

	//Busquedas por Carrera
	//Por Nombre
	public List<Carrera> findByNombreContaining(String nombre);
}
