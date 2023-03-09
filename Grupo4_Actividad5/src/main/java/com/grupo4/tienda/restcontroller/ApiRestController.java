package com.grupo4.tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.ProductoDaoImpl;
import com.grupo4.tienda.modelo.dao.UsuarioDaoImpl;

@RestController
@RequestMapping
public class ApiRestController {
	
	@Autowired
	private ProductoDaoImpl ppdao;
	
	@Autowired
	private UsuarioDaoImpl udao;
	
	@GetMapping("/precio/{id}")
	public double precioProducto(@PathVariable("id")int id) {
		double producto = ppdao.buscarUno(id).getPrecio();
		return producto;
	}
	
	@GetMapping("/tipo/stockdisponible")
	public List<Producto> tipoProducto() {
		List<Producto> producto = ppdao.listadoProductos();
		return producto;
	}
	
	@GetMapping("/usuario/{localidad}")
	public List<Usuario> listadoClientesCiudad(@PathVariable("localidad") String localidad) {
		List<Usuario> listaUsuarios = udao.consultarLocalidad(localidad);
		System.out.println(localidad);
		return listaUsuarios;
	}
}
