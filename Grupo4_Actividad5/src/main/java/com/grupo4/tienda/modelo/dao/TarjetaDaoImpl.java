package com.grupo4.tienda.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo4.tienda.entities.Producto;
import com.grupo4.tienda.entities.Tarjeta;
import com.grupo4.tienda.repository.TarjetaRepository;

@Repository
public class TarjetaDaoImpl implements TarjetaDao{
	
	@Autowired
	private TarjetaRepository trepo;

	@Override
	public List<Tarjeta> listadoTarjetasPorUsuario(int idUsuario) {
		List<Tarjeta> tarjetas = trepo.findAll();
		return tarjetas;
	}
	
	@Override
	public boolean añadirTarjeta(Tarjeta tarjeta) {
		try{
			trepo.save(tarjeta);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean eliminarTarjeta(int idTarjeta) {
		try {
			trepo.deleteById(idTarjeta);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarTarjeta(Tarjeta tarjeta) {
		trepo.save(tarjeta);
		return true;		
	}
	
	@Override
	public Tarjeta consultarUno(int idTarjeta) {;
		return trepo.findById(idTarjeta).orElse(null);		
	}
	
	
	
}
