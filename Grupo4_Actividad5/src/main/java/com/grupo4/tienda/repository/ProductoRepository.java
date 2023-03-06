package com.grupo4.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo4.tienda.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p from Producto p order by precio asc")
	public List<Producto> buscarPorPrecioAscendente();
	
	
}
