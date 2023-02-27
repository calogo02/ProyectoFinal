package com.carlos.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "difunto")
public class DifuntoEntity {

	@Id
	@Column(name = "iddifunto")
	private Integer idDifunto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fechadefuncion")
	private String fechaDefuncion;

	@OneToOne(mappedBy = "difunto")
	private ServicioEntity servicio;

	public DifuntoEntity(Integer idDifunto, String nombre, String apellidos, String fechaDefuncion,
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(String fechaDefuncion) {
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
