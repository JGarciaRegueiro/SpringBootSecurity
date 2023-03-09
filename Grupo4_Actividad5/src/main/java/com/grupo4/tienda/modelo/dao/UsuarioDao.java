package com.grupo4.tienda.modelo.dao;

import java.util.List;

import com.grupo4.tienda.entities.Usuario;

public interface UsuarioDao {
	
	boolean altaUsuario(Usuario usuario);
	int consultarUsuario(String username);
	Usuario consultarUno(int idUsuario);
	boolean modificarUsuario(Usuario usuario);
	List<Usuario> consultarTodos();
	boolean eliminarUsuario (int idUsuario);
	List<Usuario> consultarLocalidad(String localidad);
	
}
