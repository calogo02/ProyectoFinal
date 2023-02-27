package com.carlos.gestion.dto;

public class DetallesFacturaDTO {
	
	private Producto producto;
	
	private double precio;
	
	private double impuestos;

	public DetallesFacturaDTO(Producto producto, double precio, double impuestos) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.impuestos = impuestos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	

}
