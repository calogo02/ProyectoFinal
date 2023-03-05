package com.carlos.gestion.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class ServicioEntity {

	@Id
	@Column(name = "idservicio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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


	@OneToMany(mappedBy = "servicio")
	private Set<FacturaEntity> facturas;

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

	public Set<FacturaEntity> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<FacturaEntity> facturas) {
		this.facturas = facturas;
	}

	public ServicioEntity() {
		super();
	}

	public ServicioEntity(Integer idServicio, DifuntoEntity difunto, String fechaServicio, String velatorio,
			String enterramiento, Integer literales, Integer ultimasvoluntades) {
		super();
		this.idServicio = idServicio;
		this.difunto = difunto;
		this.fechaServicio = fechaServicio;
		this.velatorio = velatorio;
		this.enterramiento = enterramiento;
		this.literales = literales;
		this.ultimasvoluntades = ultimasvoluntades;
	}

}
