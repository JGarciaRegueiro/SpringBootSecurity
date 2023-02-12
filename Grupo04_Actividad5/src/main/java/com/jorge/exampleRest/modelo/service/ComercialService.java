package com.jorge.exampleRest.modelo.service;

import java.util.List;

import com.jorge.exampleRest.modelo.entities.Comercial;
import com.jorge.exampleRest.modelo.entities.Pedido;

public interface ComercialService {

	Comercial altaComercial(Comercial comercial);
	Boolean eliminarComercial(int idComercial);
	Comercial consultarComercial(int idComercial);
	List<Comercial> consultarComercialesPorCliente(int idCliente);
	List<Comercial> consultarComercialesConPedido();
	List<Pedido> consultarPedidosPorComercial(int idComercial);
	
}
