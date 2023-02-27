package com.grupo4.tienda.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.math.BigInteger;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private int idTarjeta;

	private int cvv;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_caducidad")
	private Timestamp fechaCaducidad;

	private String nombre;

	@Column(name="numero_tarjeta")
	private BigInteger numeroTarjeta;

	public Tarjeta() {
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Timestamp getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Timestamp fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(BigInteger numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tarjeta))
			return false;
		Tarjeta other = (Tarjeta) obj;
		return idTarjeta == other.idTarjeta;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", cvv=" + cvv + ", fechaCaducidad=" + fechaCaducidad + ", nombre="
				+ nombre + ", numeroTarjeta=" + numeroTarjeta + "]";
	}
	
	

}