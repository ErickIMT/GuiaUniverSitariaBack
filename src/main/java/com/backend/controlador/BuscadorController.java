package com.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.modelo.Carrera;
import com.backend.modelo.Universidad;
import com.backend.servicio.CarreraService;
import com.backend.servicio.UniversidadService;

@RestController
@RequestMapping("/buscar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuscadorController {
	
	@Autowired
	private UniversidadService uniServ;
	
	@Autowired
	private CarreraService carServ;

	
	//Busquedas en Universidad (Nombre y Siglas)
	@GetMapping("/universidad/{query}")
	public ResponseEntity<?> buscarUniversidad(@PathVariable("query") String query){
		
		List<Universidad> uniNombreResult = this.uniServ.buscarPorNombre(query);
		List<Universidad> uniSiglasResult = this.uniServ.buscarPorSiglas(query);
		
		uniNombreResult.addAll(uniSiglasResult);
		
		return new ResponseEntity<>(uniNombreResult,HttpStatus.OK);		
	}
	
	//Busquedas con Carrera
	@GetMapping("/carrera/{query}")
	public ResponseEntity<?> buscarPorCarrera(@PathVariable("query") String query){
		
		List<Carrera> carrerasResult = this.carServ.buscarPorNombre(query);
		
		return new ResponseEntity<>(carrerasResult,HttpStatus.OK);
	}
	
	
}
