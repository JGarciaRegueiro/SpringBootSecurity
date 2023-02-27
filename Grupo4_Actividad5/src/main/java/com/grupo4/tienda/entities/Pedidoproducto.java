package com.grupo4.tienda.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the pedidoproductos database table.
 * 
 */
@Entity
@Table(name="pedidoproductos")
@NamedQuery(name="Pedidoproducto.findAll", query="SELECT p FROM Pedidoproducto p")
public class Pedidoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedidoproductos")
	private int idPedidoproductos;

	private int cantidad;

	private double importe;

	//uni-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public Pedidoproducto() {
	}

	public int getIdPedidoproductos() {
		return this.idPedidoproductos;
	}

	public void setIdPedidoproductos(int idPedidoproductos) {
		this.idPedidoproductos = idPedidoproductos;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedidoproductos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pedidoproducto))
			return false;
		Pedidoproducto other = (Pedidoproducto) obj;
		return idPedidoproductos == other.idPedidoproductos;
	}

	@Override
	public String toString() {
		return "Pedidoproducto [idPedidoproductos=" + idPedidoproductos + ", cantidad=" + cantidad + ", importe="
				+ importe + ", pedido=" + pedido + ", producto=" + producto + "]";
	}

	
}