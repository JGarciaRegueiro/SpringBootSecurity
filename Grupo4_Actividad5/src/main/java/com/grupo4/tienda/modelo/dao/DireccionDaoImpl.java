package com.grupo4.tienda.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo4.tienda.entities.Direccion;
import com.grupo4.tienda.repository.DireccionRepository;

@Repository
public class DireccionDaoImpl implements DireccionDao{

	@Autowired
	private DireccionRepository drepo;

	@Override
	public List<Direccion> listadoDireccionesPorUsuario(int idUsuario) {
		List <Direccion>direcciones = new ArrayList<>();
		for (Direccion direccion : drepo.obtenerDireccionesUsuario(idUsuario)) {
			direcciones.add(direccion);
		}
		return direcciones;
	}
	
	@Override
	public boolean añadirDireccion(Direccion direccion) {
		try{
			drepo.save(direccion);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean eliminarDireccion(int idDireccion) {
		try {
			drepo.deleteById(idDireccion);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarDireccion(Direccion direccion) {
		drepo.save(direccion);
		return true;
	}
}
