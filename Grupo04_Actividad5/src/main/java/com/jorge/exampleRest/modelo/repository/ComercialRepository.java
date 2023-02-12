package com.jorge.exampleRest.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.exampleRest.modelo.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{

}
