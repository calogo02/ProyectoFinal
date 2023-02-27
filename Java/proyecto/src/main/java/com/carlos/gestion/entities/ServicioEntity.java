package com.carlos.funeraria.entities;

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
	private DifuntoEntity idDifunto;

	@Column(name = "fechaservicio")
	private String fechaServicio;

	@Column(name = "velatorio")
	private Integer velatorio;

	@Column(name = "enterramiento")
	private Integer enterramiento;

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

	public DifuntoEntity getIdDifunto() {
		return idDifunto;
	}

	public void setIdDifunto(DifuntoEntity idDifunto) {
		this.idDifunto = idDifunto;
	}

	public String getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(String fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public Integer getVelatorio() {
		return velatorio;
	}

	public void setVelatorio(Integer velatorio) {
		this.velatorio = velatorio;
	}

	public Integer getEnterramiento() {
		return enterramiento;
	}

	public void setEnterramiento(Integer enterramiento) {
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

	public ServicioEntity(Integer idServicio, DifuntoEntity idDifunto, String fechaServicio, Integer velatorio,
			Integer enterramiento, Integer literales, Integer ultimasvoluntades) {
		super();
		this.idServicio = idServicio;
		this.idDifunto = idDifunto;
		this.fechaServicio = fechaServicio;
		this.velatorio = velatorio;
		this.enterramiento = enterramiento;
		this.literales = literales;
		this.ultimasvoluntades = ultimasvoluntades;
	}

}
