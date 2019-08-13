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
public class rig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String continente;
	private double superficie_terrestre;
	private double superficie_maritima;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

