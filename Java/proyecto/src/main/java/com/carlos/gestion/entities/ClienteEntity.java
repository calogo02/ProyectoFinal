package com.carlos.gestion.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente")
	private Integer idCliente;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@ManyToOne
	@JoinColumn(name="regimenfiscal")
	private RegimenFiscalEntity regimenFiscal;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "metodopago")
	private String metodoDePago;
	
	@OneToMany(mappedBy = "cliente")
	private Set<FacturaEntity> listaFacturas;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public RegimenFiscalEntity getRegimenFiscal() {
		return regimenFiscal;
	}

	public void setRegimenFiscal(RegimenFiscalEntity regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public Set<FacturaEntity> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(Set<FacturaEntity> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public ClienteEntity() {
		super();
	}

	public ClienteEntity(Integer idCliente, String nombre, String apellidos, RegimenFiscalEntity regimenFiscal,
			String direccion, String metodoDePago, Set<FacturaEntity> listaFacturas) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.regimenFiscal = regimenFiscal;
		this.direccion = direccion;
		this.metodoDePago = metodoDePago;
		this.listaFacturas = listaFacturas;
	}


}
