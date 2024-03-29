package com.cenfotec.examen3.controllers;

import java.text.ParseException;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.model.planta;
import com.cenfotec.examen3.model.rig;
import com.cenfotec.examen3.repository.PlantaRepository;
import com.cenfotec.examen3.repository.RigRepository;

@RestController
@RequestMapping({ "/rig" })
public class RigController {

	private RigRepository repository;
	private PlantaRepository plantaRepository;

	RigController(RigRepository rigRepository) {
		this.repository = rigRepository;
	}
	

	@GetMapping({ "/lista" })
	public List obtenerListaCompleta() {
		return repository.findAll();
	}

	@GetMapping(path = { "lista/{id}" })
	public ResponseEntity<rig> obtenerListaPorId(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping({ "/registrar" })
	public rig registrarRig(@RequestBody rig rig) {
		return repository.save(rig);
	}
	

}
