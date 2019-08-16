package com.cenfotec.examen3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen3.model.animal;

public interface AnimalRepository extends JpaRepository<animal, Long> {

}
