package com.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.modelo.Universidad;
import com.backend.servicio.UniversidadService;

@RestController
@RequestMapping("/rest/universidad")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UniversidadRestController {
	
	@Autowired
	private UniversidadService uniServ;

	@GetMapping
	public ResponseEntity<Page<Universidad>> pagCarreras(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
													@RequestParam(defaultValue = "nombre")String order, @RequestParam(defaultValue = "true") boolean asc){
		Page<Universidad> universidades = uniServ.paginas(PageRequest.of(page, size, Sort.by(order)));
		if(!asc) 
			universidades = uniServ.paginas(PageRequest.of(page, size, Sort.by(order).descending()));
			return new ResponseEntity<Page<Universidad>>(universidades, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		Universidad universidad = uniServ.buscarPorId(id);
		
		if(universidad == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Universidad con el id");
		}
		
		return new ResponseEntity<>(universidad,HttpStatus.OK);
	}
}
