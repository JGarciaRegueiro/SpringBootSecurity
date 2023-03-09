package com.grupo4.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo4.tienda.entities.Direccion;
import com.grupo4.tienda.entities.Tarjeta;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {


}
