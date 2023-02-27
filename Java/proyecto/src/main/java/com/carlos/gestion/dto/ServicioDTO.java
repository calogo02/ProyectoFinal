package com.carlos.gestion.dto;

public class ServicioDTO {

	private Integer idServicio;
	private String fechaServicio;
	private String lugarVelatorio;
	private String lugarEnterramiento;
	private DifuntoDTO difunto;
	private Integer literales;
	private Integer ultimasVoluntades;

	public ServicioDTO(Integer idServicio, String fechaServicio, String lugarVelatorio, String lugarEnterramiento,
			DifuntoDTO difunto, Integer literales, Integer ultimasVoluntades) {
		super();
		this.idServicio = idServicio;
		this.fechaServicio = fechaServicio;
		this.lugarVelatorio = lugarVelatorio;
		this.lugarEnterramiento = lugarEnterramiento;
		this.difunto = difunto;
		this.literales = literales;
		this.ultimasVoluntades = ultimasVoluntades;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public String getLugarVelatorio() {
		return lugarVelatorio;
	}

	public void setLugarVelatorio(String lugarVelatorio) {
		this.lugarVelatorio = lugarVelatorio;
	}

	public String getLugarEnterramiento() {
		return lugarEnterramiento;
	}

	public void setLugarEnterramiento(String lugarEnterramiento) {
		this.lugarEnterramiento = lugarEnterramiento;
	}

	public DifuntoDTO getDifunto() {
		return difunto;
	}

	public void setDifunto(DifuntoDTO difunto) {
		this.difunto = difunto;
	}

	public Integer getLiterales() {
		return literales;
	}

	public void setLiterales(Integer literales) {
		this.literales = literales;
	}

	public Integer getUltimasVoluntades() {
		return ultimasVoluntades;
	}

	public void setUltimasVoluntades(Integer ultimasVoluntades) {
		this.ultimasVoluntades = ultimasVoluntades;
	}

}
