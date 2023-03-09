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

import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.UsuarioDao;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao udao;
	
	@GetMapping("/alta")
	public String altaUsuarioForm() {
		return "altaUsuario";
	}
	
	@PostMapping("/alta")
	public String altaUsuario(Model model, Usuario usuario){
		if(udao.altaUsuario(usuario)) {
			model.addAttribute("mensaje","Usuario añadido correctamente");
		}else {
			model.addAttribute("mensaje","Usuario NO añadido");
		}
		return "altaUsuario";
	}
	
	@GetMapping("/editar/{id}")
	public String editarUsuarioForm(Model model, @PathVariable ("id") int idUsuario){
		model.addAttribute("idUsuario",idUsuario);
		return "editarUsuario";
	}
	
	@PostMapping("/editar")
	public String editarUsuario(Usuario usuario){
		udao.modificarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") int idUsuario){
		udao.eliminarUsuario(idUsuario);
		return "redirect:/usuario";
	}
	
}
