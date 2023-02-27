package com.carlos.gestion.dto;

public class FacturasDTO {

	private Integer id;
	private Integer idTipo;
	private String nombreTipo;

	public FacturasDTO(Integer id, Integer idTipo, String nombreTipo) {
		super();
		this.id = id;
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}
