package com.jorge.exampleRest.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jorge.exampleRest.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	/*
	 * Esta query nos permite obtener el listado de pedidos a través de un comercial
	 */
	@Query("select p from Pedido p where p.comerciale.idComercial = ?1")
	public List<Pedido> buscarPorComercial (int idComercial);
}
