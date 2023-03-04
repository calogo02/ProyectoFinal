package com.carlos.gestion.dto;


public class DifuntoDTO {

	private Integer id;
	private String nombre;
	private String apellidos;
	private String fechaDefuncion;
	private String dni;

	public DifuntoDTO(Integer id, String nombre, String apellidos, String fechaDefuncion, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaDefuncion = fechaDefuncion;
		this.dni = dni;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}
