package com.backend.servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.modelo.Carrera;
import com.backend.repositorio.CarreraRepository;

@Service
@Transactional
public class CarreraService {

	@Autowired
	public CarreraRepository repoCarrera;
	
	
	public CarreraService() {}
	
	public Page<Carrera> paginas(Pageable pageable){
		return repoCarrera.findAll(pageable);
	}
	
	public Carrera buscarPoId(Integer id) {
		Optional<Carrera> carrera =  repoCarrera.findById(id);
		
		if(carrera.isPresent()) {
			return repoCarrera.findById(id).get();
		}else
			return null;
	}
	
	public List<Carrera> buscarPorNombre(String nombre){
		return repoCarrera.findByNombreContaining(nombre);
	}
}
