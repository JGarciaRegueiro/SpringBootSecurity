package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.modelo.dao.ProductoDao;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoDao pdao;

	@GetMapping("/{id}")
	public String detalleProducto(Model model, @PathVariable("id") int idProducto) {
		Producto producto = pdao.buscarUno(idProducto);
		model.addAttribute("producto",producto);
		return "detalleProducto";
	}
	
	@GetMapping("/alta")
	public String altaProductoForm() {
		return "altaProducto";
	}
	
	@PostMapping("/alta")
	public String altaProducto(Model model, Producto producto){
		if(pdao.añadirProducto(producto)) {
			model.addAttribute("mensaje","Producto añadido correctamente");
		}else {
			model.addAttribute("mensaje","Producto NO añadido");
		}
		return "altaProducto";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProductoForm(Model model, @PathVariable ("id") int idProducto){
		model.addAttribute("idProducto",idProducto);
		return "editarProducto";
	}
	
	@PostMapping("/editar")
	public String editarProducto(Producto producto){
		pdao.editarProducto(producto);
		return "redirect:/categorias";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") int idProducto){
		pdao.eliminarProducto(idProducto);
		return "redirect:/categorias";
	}
	
	
	
}
