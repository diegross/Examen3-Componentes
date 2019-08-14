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
public class divisionregional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long id_provincia;
	private Long id_pais;
	
	public Long getIdPais() {
		return id_pais;
	}

	public void setIdPais(Long id_pais) {
		this.id_pais = id_pais;
	}
	
	public Long getIdProvincia() {
		return id_provincia;
	}

	public void setIdProvincia(Long id_provincia) {
		this.id_provincia = id_provincia;
	}

}
