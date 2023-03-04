package com.carlos.gestion.dto;

import java.util.List;

public class ClienteDTO {

	private Integer id;
	private String nombre;
	private String apellidos;
	private RegimenFiscalDTO regimenFiscal;
	private String direccion;
	private String metodoPago;
	private String correoElectronico;
	private String telefono;
	private String dni;
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
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Integer id, String nombre, String apellidos, RegimenFiscalDTO regimenFiscal, String direccion,
			String metodoPago, String correoElectronico, String telefono, String dni, List<FacturasDTO> listaFacturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.regimenFiscal = regimenFiscal;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.dni = dni;
		this.listaFacturas = listaFacturas;
	}


}
