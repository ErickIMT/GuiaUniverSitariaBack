package com.backend.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "grado")
public class Grado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGrado;
	@Column(length = 50)
	private String nombre;
	
	@OneToMany(mappedBy = "grado",cascade = CascadeType.ALL)
	@JsonBackReference(value = "grado_carrera")
	private List<Carrera> carreras  = new ArrayList<>();
	
	public Grado() {
		super();
	}

	public Integer getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	
	
	
	
}
