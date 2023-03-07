package com.grupo4.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.modelo.dao.ProductoDao;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private ProductoDao pdao;
	
	@GetMapping("/precio/ascendente")
	public String buscarPorPrecioAscendente(Model model){
		List<Producto> listadoProductos=pdao.listadoPorPrecioAscendente();
		model.addAttribute("listadoProductos",listadoProductos);
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
		
}
