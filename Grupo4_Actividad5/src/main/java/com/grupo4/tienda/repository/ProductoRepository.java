package com.grupo4.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.tienda.entities.Producto;

public interface ProductoRepository extends JpaRepository <Producto,Integer>{

}
