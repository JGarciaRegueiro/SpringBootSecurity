package com.grupo4.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4.tienda.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
