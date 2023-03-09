package com.grupo4.tienda.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellidos;

	private String pass;

	private String username;

	@Column(name="fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String nombre;
	
	//uni-directional many-to-many association to Direccion
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuariosdirecciones"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_direccion")
			}
		)
	private List<Direccion> direcciones;
	
	//uni-directional many-to-many association to Tarjeta
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name="usuariostarjetas"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_tarjeta")
			}
		)
	private List<Tarjeta> tarjetas;
	

	public Usuario() {
		this.fechaRegistro = new Date();
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Direccion> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
	public void addTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<>();
		tarjetas.add(tarjeta);
	}
	
	public void removeTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<>();
		tarjetas.remove(tarjeta);
	}
	
	public void addDireccion(Direccion direccion) {
		if (direcciones == null)
			direcciones = new ArrayList<>();
		direcciones.add(direccion);
	}
	
	public void removeDireccion(Direccion direccion) {
		if (direcciones == null)
			direcciones = new ArrayList<>();
		direcciones.remove(direccion);
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellidos=" + apellidos + ", pass=" + pass
				+ ", username=" + username + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro=" + fechaRegistro
				+ ", nombre=" + nombre + "]";
	}
	
	

}