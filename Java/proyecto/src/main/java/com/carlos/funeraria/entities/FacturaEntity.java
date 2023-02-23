package com.carlos.funeraria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturaHeader")
public class FacturaEntity {

	@Id
	@Column(name = "idFactura")
	private Integer idFactura;

	@Column(name = "servicio")
	private Integer servicio;

	@OneToMany(mappedBy = "listaFacturas")
	private ClienteEntity cliente;

	@Column(name = "tipo")
	private Integer categoria;

	public FacturaEntity(Integer idFactura, Integer servicio, ClienteEntity cliente, Integer categoria) {
		super();
		this.idFactura = idFactura;
		this.servicio = servicio;
		this.cliente = cliente;
		this.categoria = categoria;
	}

	public FacturaEntity() {
		super();
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}
