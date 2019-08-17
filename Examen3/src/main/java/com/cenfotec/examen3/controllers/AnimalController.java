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
import com.cenfotec.examen3.model.divisionpolitica;
import com.cenfotec.examen3.repository.AnimalRepository;
import com.cenfotec.examen3.repository.DivisionPoliticaRepository;

@RestController
@RequestMapping({ "/animal" })
public class AnimalController {
	
	private AnimalRepository repository;
	
	AnimalController(AnimalRepository animalRepository) {
		this.repository = animalRepository;
	}
	
	@GetMapping({ "/lista" })
	public List obtenerListaCompleta() {
		return repository.findAll();
	}
	
	@GetMapping(path = { "lista/{id}" })
	public ResponseEntity<animal> obtenerListaPorId(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = { "registrar/{id}" })
	public animal registrarAnimal(@PathVariable Long id, @RequestBody animal animal) {
		animal.setIdPais(id);
		repository.save(animal);
		return repository.save(animal);
	}
	
	@GetMapping(path = { "/buscar/{nombre}" })
	public animal buscarNombre(@PathVariable String nombre) {
		
		List<animal> listaAnimal = repository.findAll();
		
		for (animal animal : listaAnimal) {
			if(animal.getNombre().equals(nombre)) {
			return animal;	
			}
		}
		return null; 
	}

}
