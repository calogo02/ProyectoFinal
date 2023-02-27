package com.carlos.funeraria.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategorioEntity {

	@Id
	@Column(name = "idcategoria")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "categoria")
	private Set<FacturaEntity> listaProductoEntity;

	@OneToMany(mappedBy = "categoria")
	private Set<ProductoEntity> listaProductosEntity;

	public CategorioEntity(Integer id, String nombre, String descripcion, Set<FacturaEntity> listaProductoEntity,
			Set<ProductoEntity> listaProductosEntity) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaProductoEntity = listaProductoEntity;
		this.listaProductosEntity = listaProductosEntity;
	}

	public CategorioEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<FacturaEntity> getListaProductoEntity() {
		return listaProductoEntity;
	}

	public void setListaProductoEntity(Set<FacturaEntity> listaProductoEntity) {
		this.listaProductoEntity = listaProductoEntity;
	}

	public Set<ProductoEntity> getListaProductosEntity() {
		return listaProductosEntity;
	}

	public void setListaProductosEntity(Set<ProductoEntity> listaProductosEntity) {
		this.listaProductosEntity = listaProductosEntity;
	}

	
}
