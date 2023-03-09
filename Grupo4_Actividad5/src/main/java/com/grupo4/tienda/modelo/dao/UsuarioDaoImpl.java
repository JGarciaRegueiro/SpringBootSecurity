package com.grupo4.tienda.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo4.tienda.entities.Usuario;
import com.grupo4.tienda.repository.UsuarioRepository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public List<Usuario> consultarTodos() {
		return urepo.findAll();
	}
	
	@Override
	public boolean altaUsuario(Usuario usuario) {
		urepo.save(usuario);
		return true;
	}

	@Override
	public int consultarUsuario (String username) {
		return urepo.obtenerUsuario(username).getIdUsuario();
	}
	
	@Override
	public Usuario consultarUno(int idUsuario){
		return urepo.findById(idUsuario).orElse(null);
	}
	
	@Override
	public boolean modificarUsuario(Usuario usuario) {
		urepo.save(usuario);
		return true;
	}
	
	@Override
	public boolean eliminarUsuario(int idUsuario) {
		try {
			urepo.deleteById(idUsuario);	
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Usuario> consultarLocalidad(String localidad) {
		List<Usuario> listaUsuarios = new ArrayList<>();
		for (Usuario usuario : urepo.findAll()) {
			if(usuario.getDirecciones().toString().contains(localidad)) {
				listaUsuarios.add(usuario);
			}
		}
		return listaUsuarios;
	}
	
	
}
