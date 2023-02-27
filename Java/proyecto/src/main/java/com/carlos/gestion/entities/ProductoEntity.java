package com.carlos.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntity {

	@Id
	@Column(name = "idproducto")
	private Integer idProducto;

	@ManyToOne
	@JoinColumn(name = "categoria")
	private CategorioEntity categoria;

	@Column(name = "nombreproducto")
	private String nombreproducto;

	@Column(name = "precioUnitario")
	private Integer precioUnitario;

	public ProductoEntity(Integer idProducto, CategorioEntity categoria, String nombreproducto,
			Integer precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.nombreproducto = nombreproducto;
		this.precioUnitario = precioUnitario;
	}

	public ProductoEntity() {
		super();
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public CategorioEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategorioEntity categoria) {
		this.categoria = categoria;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

}
