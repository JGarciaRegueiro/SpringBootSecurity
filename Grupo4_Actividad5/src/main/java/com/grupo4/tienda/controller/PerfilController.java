package com.grupo4.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    int idUsuario = udao.consultarUsuario(userDetail.getUsername());
	    udao.consultarUno(idUsuario).addTarjeta(tarjeta);
	    udao.modificarUsuario(udao.consultarUno(idUsuario));
		return "redirect:/perfil";
	}

	@GetMapping("/tarjeta/eliminar/{id}")
	public String procEliminarTarjeta(@PathVariable("id") int idTarjeta){
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    int idUsuario = udao.consultarUsuario(userDetail.getUsername());
		udao.consultarUno(idUsuario).removeTarjeta(tdao.consultarUno(idTarjeta));
	    udao.modificarUsuario(udao.consultarUno(idUsuario));
		return "redirect:/perfil";
	}
	
	@GetMapping("/tarjeta/editar/{id}")
	public String modificarTarjetaForm(Model model, @PathVariable ("id") int idTarjeta){
		model.addAttribute("idTarjeta",idTarjeta);
		return "modificarTarjeta";
	}
	
	@PostMapping("/tarjeta/editar")
	public String modificarTarjetaUsuario(Tarjeta tarjeta){
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
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    int idUsuario = udao.consultarUsuario(userDetail.getUsername());
	    udao.consultarUno(idUsuario).addDireccion(direccion);
	    udao.modificarUsuario(udao.consultarUno(idUsuario));
		return "redirect:/perfil";
	}
	
	@GetMapping("/direccion/eliminar/{id}")
	public String procEliminarDireccion(@PathVariable("id") int idDireccion){
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    int idUsuario = udao.consultarUsuario(userDetail.getUsername());
	    udao.consultarUno(idUsuario).removeDireccion(ddao.consultarUno(idDireccion));
	    udao.modificarUsuario(udao.consultarUno(idUsuario));
		return "redirect:/perfil";
	}
	
	
	@GetMapping("/direccion/editar/{id}")
	public String modificarDireccionForm(Model model, @PathVariable ("id") int idDireccion){
		model.addAttribute("idDireccion",idDireccion);
		return "modificarDireccion";
	}
	
	@PostMapping("/direccion/editar")
	public String modificarDireccionUsuario(Direccion direccion){
		ddao.modificarDireccion(direccion);
		return "redirect:/perfil";
	}

	
	
}
