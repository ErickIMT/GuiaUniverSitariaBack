package com.backend.servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.modelo.Universidad;
import com.backend.repositorio.UniversidadRepository;

@Service
@Transactional
public class UniversidadService {

	@Autowired
	public UniversidadRepository uniRepo;
	
	public UniversidadService() {}
	
	public Page<Universidad> paginas(Pageable pageable){
		return uniRepo.findAll(pageable);
	}
	
	public Universidad buscarPorId(Integer id) {
		Optional<Universidad> busqueda = uniRepo.findById(id);
		
		if(busqueda.isPresent()) {
			return uniRepo.findById(id).get();
		}else
			return null;		
	}
	
	public List<Universidad> buscarPorNombre(String nombre){
		return uniRepo.findByNombreContaining(nombre);
	}
	
	public List<Universidad> buscarPorSiglas(String siglas){
		return uniRepo.findBySiglasContaining(siglas);
	}
}
