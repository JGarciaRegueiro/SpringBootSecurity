package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.tienda.modelo.dao.ProductoDao;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private ProductoDao pdao;
	
	@GetMapping("/precio/ascendente")
	public String buscarPorPrecioAscendente(Model model){
		model.addAttribute("listadoProductos",pdao.listadoPorPrecioAscendente());
		return "categoria";
	}
	
	@GetMapping("/precio/descendente")
	public String buscarPorPrecioDescendente(Model model){
		model.addAttribute("listadoProductos",pdao.listadoPorPrecioDescendente());
		return "categoria";
	}
	
	@GetMapping("/stock")
	public String buscarPorStock(Model model){
		model.addAttribute("listadoProductos",pdao.listadoPorMenorStock());
		return "categoria";
	}
	
	@PostMapping("/producto/alta")
	public String altaProducto(){
		
		return "categoria";
	}
	
	@PutMapping("/producto/editar/{id}")
	public String editarProducto(){
		
		return "categoria";
	}
	
	@DeleteMapping("/producto/eliminar/{id}")
	public String eliminarProducto(){
		
		return "categoria";
	}
	
	
	

}
