package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo4.tienda.entities.Direccion;
import com.grupo4.tienda.entities.Tarjeta;
import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.DireccionDaoImpl;
import com.grupo4.tienda.modelo.dao.TarjetaDaoImpl;
import com.grupo4.tienda.modelo.dao.UsuarioDaoImpl;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private UsuarioDaoImpl udao;
	@Autowired
	private TarjetaDaoImpl tdao;
	@Autowired
	private DireccionDaoImpl ddao;

	
	//URLS CORRESPONDIENTES A TARJETAS

	@GetMapping("/tarjeta/alta")
	public String procAltaTarjeta(){
		return "altaTarjeta";
	}
	
	@PostMapping("/tarjeta/alta")
	public String altaTarjeta(Model model, Tarjeta tarjeta){
		if(tdao.añadirTarjeta(tarjeta)) {
			model.addAttribute("mensaje","Tarjeta añadida correctamente");
		}else {
			model.addAttribute("mensaje","Tarjeta NO añadida");
		}
		return "altaTarjeta";
	}

	
	@GetMapping("/tarjeta/eliminar/{id}")
	public String procEliminarTarjeta(@PathVariable("id") int idTarjeta){
		tdao.eliminarTarjeta(idTarjeta);
		return "redirect:/perfil";
	}
	
	@GetMapping("/tarjeta/modificar/{id}")
	public String modificarTarjetaForm(Model model, @PathVariable ("id") int idTarjeta){
		model.addAttribute("idTarjeta",idTarjeta);
		return "modificarTarjeta";
	}
	
	@PostMapping("/tarjeta/modificar")
	public String modificarTarjeta(Tarjeta tarjeta){
		tdao.modificarTarjeta(tarjeta);
		return "redirect:/perfil";
	}
	
	//URLS CORRESPONDIENTES A DIRECCIONES

	
	@GetMapping("/direccion/alta")
	public String procAltaDireccion(){
		return "altaDireccion";
	}
	
	@PostMapping("/direccion/alta")
	public String altaDireccion(Model model, Direccion direccion){
		if(ddao.añadirDireccion(direccion)) {
			model.addAttribute("mensaje","Dirección añadida correctamente");
		}else {
			model.addAttribute("mensaje","Dirección NO añadida");
		}
		return "altaDireccion";
	}
	
	@GetMapping("/direccion/eliminar/{id}")
	public String procEliminarDireccion(@PathVariable("id") int idDireccion){
		ddao.eliminarDireccion(idDireccion);
		return "redirect:/perfil";
	}
	
	@GetMapping("/direccion/modificar/{id}")
	public String modificarDireccionForm(Model model, @PathVariable ("id") int idDireccion){
		model.addAttribute("idDireccion",idDireccion);
		return "modificarDireccion";
	}
	
	@PostMapping("/tarjeta/modificar")
	public String modificarDireccion(Direccion direccion){
		ddao.modificarDireccion(direccion);
		return "redirect:/perfil";
	}

	
	
}
