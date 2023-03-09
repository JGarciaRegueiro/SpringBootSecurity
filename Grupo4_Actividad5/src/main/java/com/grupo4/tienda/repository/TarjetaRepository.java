package com.grupo4.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo4.tienda.entities.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
	
//	@Query ("select * from Tarjeta t join UsuariosTarjeta ut on t.id_tarjeta = ut.id_tarjeta where ut.id_usuario=?1")
	@Query ("select t from Tarjeta t inner join Usuario u where id_usuario=?1")
	public List<Tarjeta> obtenerTarjetasPorIdUsuario(int idUsuario);
	
}
