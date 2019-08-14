package com.cenfotec.examen3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen3.model.divisionregional;


@Repository
public interface DivisionRegionalRepository extends JpaRepository<divisionregional, Long>  {


}