package com.carlos.gestion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class ServicioEntity {

	@Id
	@Column(name = "idservicio")
	private Integer idServicio;

	@OneToOne
	@JoinColumn(name = "iddifunto")
	private DifuntoEntity difunto;

	@Column(name = "fechaservicio")
	private String fechaServicio;

	@Column(name = "velatorio")
	private String velatorio;

	@Column(name = "enterramiento")
	private String enterramiento;

	@Column(name = "literales")
	private Integer literales;

	@Column(name = "ultimasvoluntades")
	private Integer ultimasvoluntades;

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public DifuntoEntity getDifunto() {
		return difunto;
	}

	public void setDifunto(DifuntoEntity difunto) {
		this.difunto = difunto;
	}

	public String getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public String getVelatorio() {
		return velatorio;
	}

	public void setVelatorio(String velatorio) {
		this.velatorio = velatorio;
	}

	public String getEnterramiento() {
		return enterramiento;
	}

	public void setEnterramiento(String enterramiento) {
		this.enterramiento = enterramiento;
	}

	public Integer getLiterales() {
		return literales;
	}

	public void setLiterales(Integer literales) {
		this.literales = literales;
	}

	public Integer getUltimasvoluntades() {
		return ultimasvoluntades;
	}

	public void setUltimasvoluntades(Integer ultimasvoluntades) {
		this.ultimasvoluntades = ultimasvoluntades;
	}

	public ServicioEntity() {
		super();
	}

	public ServicioEntity(Integer idServicio, DifuntoEntity idDifunto, String fechaServicio, String velatorio,
			String enterramiento, Integer literales, Integer ultimasvoluntades) {
		super();
		this.idServicio = idServicio;
		this.difunto = idDifunto;
		this.fechaServicio = fechaServicio;
		this.velatorio = velatorio;
		this.enterramiento = enterramiento;
		this.literales = literales;
		this.ultimasvoluntades = ultimasvoluntades;
	}

}
