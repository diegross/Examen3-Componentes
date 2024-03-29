package com.cenfotec.examen3.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.model.divisionregional;
import com.cenfotec.examen3.repository.DivisionRegionalRepository;

@RestController
@RequestMapping({ "/regional" })
public class DivisionRegionalController {
	
	private DivisionRegionalRepository repository;
	
	DivisionRegionalController(DivisionRegionalRepository reigonalRepository) {
		this.repository = reigonalRepository;
	}
	
	@GetMapping({ "/lista" })
	public List obtenerListaCompleta() {
		return repository.findAll();
	}
	
	@GetMapping(path = { "lista/{id}" })
	public ResponseEntity<divisionregional> obtenerListaPorId(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = { "registrar/{id_pais}/{id_provincia}" })
	public divisionregional registrarDivisionRegional(@PathVariable Long id_pais,@PathVariable Long id_provincia, @RequestBody divisionregional division) {
		division.setIdPais(id_pais);
		division.setIdProvincia(id_provincia);
		repository.save(division);
		return repository.save(division);
	}
	
	@GetMapping(path = { "/buscar/{nombre}" })
	public divisionregional buscarNombre(@PathVariable String nombre) {
		
		List<divisionregional> regiones = repository.findAll();
		
		for (divisionregional divisionregional : regiones) {
			if(divisionregional.getNombre().equals(nombre)) {
			return divisionregional;	
			}
		}
		return null; 
	}
	
}
