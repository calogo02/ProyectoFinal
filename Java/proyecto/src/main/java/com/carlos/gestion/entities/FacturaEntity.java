package com.carlos.funeraria.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturaheader")
public class FacturaEntity {

	@Id
	@Column(name = "idfactura")
	private Integer idFactura;

	@ManyToOne
	@JoinColumn(name="servicio")
	private ServicioEntity servicio;

	@ManyToOne
	@JoinColumn(name="cliente")
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name="tipo")
	private CategorioEntity categoria;

	@OneToMany(mappedBy = "factura")
	private List<LineaDeProductoEntity> lineasDeProducto; 
	
	public FacturaEntity(Integer idFactura, ServicioEntity servicio, ClienteEntity cliente, CategorioEntity categoria) {
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

	public ServicioEntity getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntity servicio) {
		this.servicio = servicio;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public CategorioEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategorioEntity categoria) {
		this.categoria = categoria;
	}

}
