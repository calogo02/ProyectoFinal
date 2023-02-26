package com.carlos.funeraria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facturaheader")
public class DifuntoEntity {

	@Id
	@Column(name = "iddifunto")
	private Integer idDifunto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private Integer apellidos;

	@Column(name = "fechadefuncion")
	private Integer fechaDefuncion;

	@OneToOne(mappedBy = "idDifunto")
	private ServicioEntity servicio;

	public DifuntoEntity(Integer idDifunto, String nombre, Integer apellidos, Integer fechaDefuncion,
			ServicioEntity servicio) {
		super();
		this.idDifunto = idDifunto;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaDefuncion = fechaDefuncion;
		this.servicio = servicio;
	}

	public Integer getIdDifunto() {
		return idDifunto;
	}

	public void setIdDifunto(Integer idDifunto) {
		this.idDifunto = idDifunto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getApellidos() {
		return apellidos;
	}

	public void setApellidos(Integer apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(Integer fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public ServicioEntity getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntity servicio) {
		this.servicio = servicio;
	}

	public DifuntoEntity() {
		super();
	}

}
