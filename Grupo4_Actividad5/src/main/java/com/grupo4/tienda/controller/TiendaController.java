package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.UsuarioDaoImpl;

@Controller
@RequestMapping
public class TiendaController {
	
	@Autowired
	private UsuarioDaoImpl udao;

	@GetMapping("/inicio")
	public String procInicio(){
		return "inicio";
	}
	
	@GetMapping("/categorias")
	public String procCategoria(){
		return "categoria";
	}
	
	@GetMapping("/login")
	public String procLogin(){
		return "login";
	}
	
	@PostMapping("/login")
	public String procIniciarSesion(){
		return "login";
	}
	
	@GetMapping("/registro")
	public String procRegistro(){
		return "registro";
	}
	
	@PostMapping("/registro")
	public String procRegistroUsuario(Usuario usuario){
		System.out.println(usuario);
		udao.altaUsuario(usuario);
		return "registro";
	}
	
	@GetMapping("/perfil")
	public String procPerfil(){
		return "perfil";
	}
	
	@GetMapping("/carrito")
	public String procCarrito(){
		return "carrito";
	}
}
