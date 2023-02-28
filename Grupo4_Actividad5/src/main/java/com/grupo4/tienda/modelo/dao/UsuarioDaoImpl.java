package com.grupo4.tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public boolean altaUsuario(Usuario usuario) {
		urepo.save(usuario);
		return true;
	}

	@Override
	public boolean consultarUsuario (Usuario usuario) {
		
		return false;
	}

}
