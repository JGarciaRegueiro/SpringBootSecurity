package com.grupo4.tienda.modelo.dao;

import java.util.List;

import com.grupo4.tienda.entities.Direccion;

public interface DireccionDao {
	
	List<Direccion> listadoDireccionesPorUsuario(int idUsuario);
	boolean añadirDireccion(Direccion direccion);
	boolean eliminarDireccion(int idDireccion);
	boolean modificarDireccion(Direccion direccion);

}
