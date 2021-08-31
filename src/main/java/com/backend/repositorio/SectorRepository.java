package com.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.modelo.Sector;

public interface SectorRepository extends JpaRepository<Sector, Integer> {
	
	//Busqueda
	//Por Sector(Publico o Privado)
	public List<Sector> findByIdSector(Integer idSector);

}
