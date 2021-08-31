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
@Table(name = "sector")
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSector;
	@Column(length = 10)
	private String nombre;
	@OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
	@JsonBackReference(value = "sector_universidad")
	private List<Universidad>universidades = new ArrayList<>();
	
	public Sector() {
		super();
	}

	public Integer getIdSector() {
		return idSector;
	}

	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Universidad> getUniversidades() {
		return universidades;
	}

	public void setUniversidades(List<Universidad> universidades) {
		this.universidades = universidades;
	}
	
	
}
