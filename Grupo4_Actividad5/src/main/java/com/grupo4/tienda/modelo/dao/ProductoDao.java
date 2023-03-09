package com.grupo4.tienda.modelo.dao;

import java.util.List;

import com.grupo4.tienda.entities.Producto;

public interface ProductoDao {

	List<Producto> listadoProductos();
	Producto buscarUno(int idProducto);
	boolean añadirProducto(Producto producto);
	boolean eliminarProducto(int idProducto);
	boolean editarProducto(Producto producto);
	List<Producto> listadoPorPrecioAscendente();
	List<Producto> listadoPorPrecioDescendente();
	List<Producto> listadoPorMenorStock();
	List<Producto> listadoProductosStock();
}
