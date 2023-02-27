package com.carlos.gestion.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regimenfiscal")
public class RegimenFiscalEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(mappedBy = "regimenFiscal")
	private Set<ClienteEntity> clientes;

	public RegimenFiscalEntity(Integer id, String nombre, String descripcion, Set<ClienteEntity> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.clientes = clientes;
	}

	public RegimenFiscalEntity() {
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

	public Set<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(Set<ClienteEntity> clientes) {
		this.clientes = clientes;
	}
}
