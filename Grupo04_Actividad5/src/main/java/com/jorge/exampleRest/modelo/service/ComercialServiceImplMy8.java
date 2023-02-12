package com.jorge.exampleRest.modelo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.exampleRest.modelo.entities.Comercial;
import com.jorge.exampleRest.modelo.entities.Pedido;
import com.jorge.exampleRest.modelo.repository.ComercialRepository;
import com.jorge.exampleRest.modelo.repository.PedidoRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService {

	@Autowired
	private ComercialRepository cRepo;
	
	@Autowired
	private PedidoRepository pRepo;
	
	/*
	 * Este método permite dar de alta un comercial, comprueba si el comercial existe y si existe devolvería null pero 
	 * si no existe y el alta es correcta devuelve el objeto comercial dado de alta.
	*/
	@Override
	public Comercial altaComercial(Comercial comercial) {
		if (consultarComercial(comercial.getIdComercial()) == null) {
			return cRepo.save(comercial);
		}
		return null;
	}

	/*
	 * Este método permite eliminar un comercial, comrpueba si el comercial existe y si existe devolvería true tras eliminarlo pero 
	 * si no existe o salta una excepción devuelve false.
	*/
	@Override
	public Boolean eliminarComercial(int idComercial) {
		try {
			if (consultarComercial(idComercial) != null) {
				cRepo.deleteById(idComercial);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/*
	 * Este método permite consultar la información o el objeto de un comercial a través del id de comercial, si
	 * el comercial no existiera devolvería null
	*/
	@Override
	public Comercial consultarComercial(int idComercial) {
		return cRepo.findById(idComercial).orElse(null);
	}

	/*
	 * Este método permite consultar la lista de los comerciales que han atendido pedidos del cliente que coincida con el id enviado
	*/
	@Override
	public List<Comercial> consultarComercialesPorCliente(int idCliente) {
		List<Comercial> listaComerciales = new ArrayList<>();
		for (Pedido pedido : pRepo.findAll()) {
			if (pedido.getCliente().getIdCliente() == idCliente) {
				if (listaComerciales.contains(pedido.getComerciale())) {
					continue;
				} else {
					listaComerciales.add(pedido.getComerciale());
				}
			}
		}
		return listaComerciales;
	}

	/*
	 * Este método permite consultar la lista de comerciales que han atendido algún pedido
	*/
	@Override
	public List<Comercial> consultarComercialesConPedido() {
		List<Comercial> listaComerciales = new ArrayList<>();
		for (Comercial comercial : cRepo.findAll()) {
			for (Pedido pedido : pRepo.findAll()) {
				if (pedido.getComerciale() == comercial) {
					if (listaComerciales.contains(pedido.getComerciale())) {
						continue;
					} else {
						listaComerciales.add(pedido.getComerciale());
					}
				}
			}
		}
		return listaComerciales;
	}

	/*
	 * Este método permite consultar la lista de pedidos gestionados por el comercial que coincida con ese id.
	*/
	@Override
	public List<Pedido> consultarPedidosPorComercial(int idComercial) {
		return pRepo.buscarPorComercial(idComercial);
	}

}
