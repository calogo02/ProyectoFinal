package com.carlos.funeraria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lineadeproducto")
public class LineaDeProductoEntity {

	@Id
	@Column(name = "id")
	private Integer idLineaProducto;

	@ManyToOne
	@JoinColumn(name = "factura")
	private FacturaEntity factura;

	@ManyToOne
	@JoinColumn(name = "producto")
	private ProductoEntity producto;

	@Column(name = "precio")
	private Double precio;

	public Integer getIdLineaProducto() {
		return idLineaProducto;
	}

	public void setIdLineaProducto(Integer idLineaProducto) {
		this.idLineaProducto = idLineaProducto;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public LineaDeProductoEntity(Integer idLineaProducto, FacturaEntity factura, ProductoEntity producto,
			Double precio) {
		super();
		this.idLineaProducto = idLineaProducto;
		this.factura = factura;
		this.producto = producto;
		this.precio = precio;
	}

	public LineaDeProductoEntity() {
		super();
	}

}
