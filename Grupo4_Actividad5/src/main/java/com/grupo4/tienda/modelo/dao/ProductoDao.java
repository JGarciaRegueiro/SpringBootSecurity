package com.grupo4.tienda.modelo.dao;

import java.util.List;

import com.grupo4.tienda.entities.Producto;

public interface ProductoDao {

	List<Producto> listadoProductos();
	boolean añadirProducto(Producto producto);
	List<Producto> listadoPorPrecioAscendente();
	List<Producto> listadoPorPrecioDescendente();
	List<Producto> listadoPorMenorStock();

}
