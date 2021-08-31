package com.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.modelo.Universidad;

public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {
	
	//Busquedas por Universidad
	//Por Nombre
	public List<Universidad> findByNombreContaining(String nombre);
	
	//Por Siglas
	public List<Universidad> findBySiglasContaining(String siglas);

}
