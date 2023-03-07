package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4.tienda.modelo.dao.ProductoDao;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoDao pdao;
	
	@GetMapping("/precio/ascendente")
	public String buscarPorPrecioAscendente(Model model){
		model.addAttribute("productos",pdao.listadoPorPrecioAscendente());
		return "producto";
	}
	
	@GetMapping("/precio/descendente")
	public String buscarPorPrecioDescendente(Model model){
		model.addAttribute("productos",pdao.listadoPorPrecioDescendente());
		return "producto";
	}
	
	@GetMapping("/stock")
	public String buscarPorStock(Model model){
		model.addAttribute("productos",pdao.listadoPorMenorStock());
		return "producto";
	}
	
	

}
