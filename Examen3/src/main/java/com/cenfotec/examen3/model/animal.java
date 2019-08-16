package com.cenfotec.examen3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_pais;
	private String nombre_popular;
	private String nombre_cientifico;
	private String peligro_extinsion;
	private double poblacion_aprox;
	
	public Long getIdPais() {
		return id_pais;
	}

	public void setIdPais(Long id_pais) {
		this.id_pais = id_pais;
	}
	
	public String getNombre() {
		return nombre_cientifico;
	}

	public void setNombre(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}

}
