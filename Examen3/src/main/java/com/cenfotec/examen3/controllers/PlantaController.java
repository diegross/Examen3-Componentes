package com.cenfotec.examen3.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.model.animal;
import com.cenfotec.examen3.model.planta;
import com.cenfotec.examen3.repository.AnimalRepository;
import com.cenfotec.examen3.repository.PlantaRepository;

@RestController
@RequestMapping({ "/planta" })
public class PlantaController {
	
private PlantaRepository repository;
	
	PlantaController(PlantaRepository plantaRepository) {
		this.repository = plantaRepository;
	}
	
	@GetMapping({ "/lista" })
	public List obtenerListaCompleta() {
		return repository.findAll();
	}
	
	@GetMapping(path = { "lista/{id}" })
	public ResponseEntity<planta> obtenerListaPorId(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = { "registrar/{id}" })
	public planta registrarPlanta(@PathVariable Long id, @RequestBody planta planta) {
		planta.setIdPais(id);
		repository.save(planta);
		return repository.save(planta);
	}
	
	@GetMapping(path = { "/buscar/{nombre}" })
	public planta buscarNombre(@PathVariable String nombre) {
		
		List<planta> listaPlanta = repository.findAll();
		
		for (planta planta : listaPlanta) {
			if(planta.getNombre().equals(nombre)) {
			return planta;	
			}
		}
		return null; 
	}

}
