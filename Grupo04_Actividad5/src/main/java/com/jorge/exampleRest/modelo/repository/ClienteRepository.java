package com.jorge.exampleRest.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.exampleRest.modelo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
}
