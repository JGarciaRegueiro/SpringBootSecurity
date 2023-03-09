package com.grupo4.tienda.modelo.dao;

import com.grupo4.tienda.entities.Usuario;

public interface UsuarioDao {
	
	boolean altaUsuario(Usuario usuario);
	int consultarUsuario(String username);
	Usuario consultarUno(int idUsuario);
}
