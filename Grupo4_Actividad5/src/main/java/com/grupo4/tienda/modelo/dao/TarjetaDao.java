package com.grupo4.tienda.modelo.dao;

import java.util.List;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.entities.Tarjeta;

public interface TarjetaDao {

	List<Tarjeta> listadoTarjetasPorUsuario(int idUsuario);
	boolean añadirTarjeta(Tarjeta tarjeta);
	boolean eliminarTarjeta(int idTarjeta);
	boolean modificarTarjeta(Tarjeta tarjeta);

}
