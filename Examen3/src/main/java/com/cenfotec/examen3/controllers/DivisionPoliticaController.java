package com.cenfotec.examen3.controllers;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.model.divisionpolitica;
import com.cenfotec.examen3.model.rig;
import com.cenfotec.examen3.repository.DivisionPoliticaRepository;
import com.cenfotec.examen3.repository.RigRepository;


@RestController
@RequestMapping({ "/politica" })
public class DivisionPoliticaController {

	private DivisionPoliticaRepository repository;

	DivisionPoliticaController(DivisionPoliticaRepository politicaRepository) {
		this.repository = politicaRepository;
	}

	@GetMapping({ "/lista" })
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "lista/{id}" })
	public ResponseEntity<divisionpolitica> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = { "registrar/{id}" })
	public divisionpolitica create(@PathVariable Long id, @RequestBody divisionpolitica division) {
		division.setIdPais(id);
		repository.save(division);
		return repository.save(division);
	}

}
