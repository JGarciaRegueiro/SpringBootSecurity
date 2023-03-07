package com.grupo4.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.ProductoDaoImpl;
import com.grupo4.tienda.modelo.dao.UsuarioDaoImpl;

@Controller
@RequestMapping
public class TiendaController {
	
	@Autowired
	private ProductoDaoImpl pdao;
	@Autowired
	private UsuarioDaoImpl udao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/inicio")
	public String procInicio(){
		return "inicio";
	}
	
	@GetMapping("/categorias")
	public String procCategoria(Model model){
		List<Producto> listadoProductos=pdao.listadoProductos();
		model.addAttribute("listadoProductos", listadoProductos);
		return "categoria";
	}
	
	@GetMapping("/login")
	public String procLogin(){
		return "login";
	}
	
	@PostMapping("/login")
	public String procIniciarSesion(RedirectAttributes ratt, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		if ((udao.consultarUsuario(username,password))){
			return "redirect:/inicio";
		} else {
			ratt.addFlashAttribute("mensaje", "Esta cuenta NO existe");
			return "login";
		}
	}
	
	@GetMapping("/registro")
	public String procRegistro(){
		return "registro";
	}
	
	@PostMapping("/registro")
	public String procRegistroUsuario(Usuario usuario){
		usuario.setPass(passwordEncoder.encode(usuario.getPass()));
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
	
	@GetMapping("/producto")
	public String procProducto(Model model){
		List<Producto> productos = pdao.listadoProductos();
		model.addAttribute("productos", productos);
		return "productos";	
	}
		
	
	@GetMapping("/usuario")
	public String procUsuario(){
		return "usuario";
	}
	
}
