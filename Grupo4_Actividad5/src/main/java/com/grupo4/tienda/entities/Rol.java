package com.grupo4.tienda.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private int idRol;

	@Column(name="nombre_rol")
	private String nombreRol;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rol))
			return false;
		Rol other = (Rol) obj;
		return idRol == other.idRol;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + "]";
	}
	
	

}