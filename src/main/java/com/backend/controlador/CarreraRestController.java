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

import com.backend.modelo.Carrera;
import com.backend.servicio.CarreraService;

@RestController
@RequestMapping("/rest/carrera")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CarreraRestController {
	@Autowired
	private CarreraService carServ;
	
	
	@GetMapping
	public ResponseEntity<Page<Carrera>> pagCarreras(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
													@RequestParam(defaultValue = "nombre")String order, @RequestParam(defaultValue = "true") boolean asc){
		Page<Carrera> carreras = carServ.paginas(PageRequest.of(page, size, Sort.by(order)));
		if(!asc) 
			carreras = carServ.paginas(PageRequest.of(page, size, Sort.by(order).descending()));
			return new ResponseEntity<Page<Carrera>>(carreras, HttpStatus.OK);		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		Carrera carrera = carServ.buscarPoId(id);
		
		if(carrera == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Carrera con el id");
		}
		
		return new ResponseEntity<>(carrera, HttpStatus.OK);
	}

}
