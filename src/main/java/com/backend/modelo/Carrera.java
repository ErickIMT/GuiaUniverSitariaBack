package com.backend.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarrera;
	@Column(length = 50)
	private String nombre;
	@Column(length = 30)
	private String duracion;
	@Column(columnDefinition = "TEXT")
	private String descripcion;
	@ManyToOne(optional = false)
	private Grado grado;	
	@ManyToMany(mappedBy = "carreras",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("carreras")
	private List<Universidad> universidades = new ArrayList<>();
	
	public Carrera() {
		super();
	}

	public Integer getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public List<Universidad> getUniversidades() {
		return universidades;
	}

	public void setUniversidades(List<Universidad> universidades) {
		this.universidades = universidades;
	}
	
	
	
}
