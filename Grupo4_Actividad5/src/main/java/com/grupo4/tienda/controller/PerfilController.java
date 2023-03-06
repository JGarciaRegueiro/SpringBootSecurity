package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.UsuarioDaoImpl;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private UsuarioDaoImpl udao;
	

	@PostMapping("/tarjeta/alta")
	public String procAltaTarjeta(){
		return "inicio";
	}
	
	@DeleteMapping("/tarjeta/eliminar/{id}")
	public String procEliminarTarjeta(){
		return "inicio";
	}
	
	@PutMapping("/tarjeta/modificar/{id}")
	public String procModificarTarjeta(){
		return "inicio";
	}
	
	@PostMapping("/direccion/alta")
	public String procAltaDireccion(){
		return "inicio";
	}
	
	@DeleteMapping("/direccion/eliminar/{id}")
	public String procEliminarDireccion(){
		return "inicio";
	}
	
	@PutMapping("/direccion/modificar/{id}")
	public String procModificarDireccion(){
		return "inicio";
	}
	
	
}
