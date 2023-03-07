package com.grupo4.tienda.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.repository.ProductoRepository;

@Repository
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	private ProductoRepository prepo;

	@Override
	public List<Producto> listadoProductos() {
		List <Producto>productos = new ArrayList<>();
		for (Producto producto : prepo.findAll()) {
			productos.add(producto);
		}
		return productos;
	}

	@Override
	public boolean añadirProducto(Producto producto) {
		prepo.save(producto);
		return true;
	}
	
	public List<Producto> listadoPorPrecioAscendente() {
		return prepo.buscarPorPrecioAscendente();
	}
	
	public List<Producto> listadoPorPrecioDescendente() {
		return prepo.buscarPorPrecioDescendente();
	}
	
	
	public List<Producto> listadoPorMenorStock(){
		return prepo.buscarPorMenosStock();
	}
	
}
