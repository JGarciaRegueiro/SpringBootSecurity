package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo4.tienda.modelo.dao.ProductoDao;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoDao pdao;

	@PostMapping("/alta")
	public String altaProducto(){
		
		return "categoria";
	}
	
	@PutMapping("/editar/{id}")
	public String editarProducto(){
		
		return "categoria";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarProducto(){
		
		return "categoria";
	}
	
}
