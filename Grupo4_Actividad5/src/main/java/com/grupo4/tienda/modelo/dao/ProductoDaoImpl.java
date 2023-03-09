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
	public Producto buscarUno(int idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public boolean añadirProducto(Producto producto) {
		try{
			System.out.println(producto);
			prepo.save(producto);
			System.out.println(producto);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean eliminarProducto(int idProducto) {
		try {
			prepo.deleteById(idProducto);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

	@Override
	public boolean editarProducto(Producto producto) {
		prepo.save(producto);
		return true;
	}

	@Override
	public List<Producto> listadoPorPrecioAscendente() {
		return prepo.buscarPorPrecioAscendente();
	}
	
	@Override
	public List<Producto> listadoPorPrecioDescendente() {
		return prepo.buscarPorPrecioDescendente();
	}
	
	@Override
	public List<Producto> listadoPorMenorStock(){
		return prepo.buscarPorMenosStock();
	}
	
	@Override
	public List<Producto> listadoProductosStock(){
		List<Producto> listadoProductos = new ArrayList<>();
		for (Producto producto : prepo.findAll()) {
			if (producto.getStock()>0) {
				listadoProductos.add(producto);
			}
		}
		return listadoProductos;
	}
	
}
