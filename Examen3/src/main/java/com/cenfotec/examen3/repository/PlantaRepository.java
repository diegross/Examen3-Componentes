package com.cenfotec.examen3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen3.model.animal;
import com.cenfotec.examen3.model.planta;

public interface PlantaRepository extends JpaRepository<planta, Long> {

}
