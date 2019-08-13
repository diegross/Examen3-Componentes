package com.cenfotec.examen3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen3.model.divisionpolitica;
import com.cenfotec.examen3.model.rig;

@Repository
public interface DivisionPoliticaRepository extends JpaRepository<divisionpolitica, Long>  {

	Optional<divisionpolitica> save(long id_pais);

	

}






