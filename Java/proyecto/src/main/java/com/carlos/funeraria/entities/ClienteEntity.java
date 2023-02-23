package com.carlos.funeraria.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@Column(name = "idCliente")
	private Integer idCliente;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@OneToMany(mappedBy = "regimenFiscal")
	private RegimenFiscal regimenFiscal;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "metodoPago")
	private String metodoDePago;
	
	@OneToMany
	@JoinColumn(name ="regimenFiscal")
	private Set<FacturaEntity> listaFacturas;


}
