package com.carlos.funeraria.dto;

import java.util.List;

public class ClienteDTO {

	private Integer id;
	private String nombre;
	private String apellidos;
	private RegimenFiscalDTO regimenFiscal;
	private String direccion;
	private String metodoPago;
	private List<FacturasDTO> listaFacturas;

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

	public RegimenFiscalDTO getRegimenFiscal() {
		return regimenFiscal;
	}

	public void setRegimenFiscal(RegimenFiscalDTO regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public List<FacturasDTO> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<FacturasDTO> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public ClienteDTO(Integer id, String nombre, String apellidos, RegimenFiscalDTO regimenFiscal, String direccion,
			String metodoPago, List<FacturasDTO> listaFacturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.regimenFiscal = regimenFiscal;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
		this.listaFacturas = listaFacturas;
	}

}
