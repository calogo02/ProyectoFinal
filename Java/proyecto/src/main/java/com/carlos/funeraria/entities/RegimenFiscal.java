package com.carlos.funeraria.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regimenfiscal")
public class RegimenFiscal {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany
	@JoinColumn(name = "regimenFiscal")
	private Set<ClienteEntity> listaFacturas;

	public RegimenFiscal(Integer id, String nombre, String descripcion, Set<ClienteEntity> listaFacturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaFacturas = listaFacturas;
	}

	public RegimenFiscal() {
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

	public Set<ClienteEntity> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(Set<ClienteEntity> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
}
