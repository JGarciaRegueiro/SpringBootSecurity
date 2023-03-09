package com.grupo4.tienda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo4.tienda.entities.Direccion;
import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.entities.Tarjeta;
import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.modelo.dao.DireccionDaoImpl;
import com.grupo4.tienda.modelo.dao.ProductoDaoImpl;
import com.grupo4.tienda.modelo.dao.TarjetaDaoImpl;
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

	@GetMapping("")
	public String procAcceso(){
		return "inicio";
	}
	
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
	public String procPerfil(Model model){
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    int idUsuario = udao.consultarUsuario(userDetail.getUsername());
	    Usuario usuario = (udao.consultarUno(idUsuario));
		List<Tarjeta> listadoTarjetas = usuario.getTarjetas();
		List<Direccion> listadoDirecciones = usuario.getDirecciones();
		model.addAttribute("usuario", usuario);
		model.addAttribute("listadoTarjetas", listadoTarjetas);
		model.addAttribute("listadoDirecciones", listadoDirecciones);
		return "perfil";
	}
	
	@GetMapping("/usuario")
	public String procUsuario(Model model){
		List<Usuario> listadoUsuarios = udao.consultarTodos();
		model.addAttribute("listadoUsuarios",listadoUsuarios);
		return "usuario";
	}
	
	@GetMapping("/carrito")
	public String procCarrito(){
		return "carrito";
	}
	
	
	
}
