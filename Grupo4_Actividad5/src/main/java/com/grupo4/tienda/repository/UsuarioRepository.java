package com.grupo4.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.tienda.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{

}
