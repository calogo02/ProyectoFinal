package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IServiciosDAO;
import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.entities.ServicioEntity;
import com.carlos.gestion.service.IServiceServicios;

@Component
public class ServiceServiciosImpl implements IServiceServicios{
	@Autowired
	IServiciosDAO servicios;

	@Override
	public List<ServicioDTO> listarTodosLosServicios() {
		return servicios.listarTodosLosServicios();
	}
	@Override
	public ServicioDTO listarServicioPorId(Integer id) {
		return servicios.listarServicioPorId(id);
	}
	@Override
	public List<ServicioDTO> listarServiciosConFiltros(String fecha, String velatorio, String enterramiento,
			String nombreDifunto) {
		return servicios.listarServiciosConFiltros(fecha, velatorio, enterramiento, nombreDifunto);	
	}

	@Override
	public Integer editarServicioAdministrativo(Integer literales, Integer ultimasVoluntades, Integer idServicio) {
		return servicios.editarServicioAdministrativo(literales, ultimasVoluntades, idServicio);
	}

	@Override
	public Integer editarServicioGestor(Integer id, ServicioEntity servicio) {
		return servicios.editarServicioGestor(id ,servicio);
	}

	@Override
	public Integer añadirFacturasServicio(Integer servicio, FacturaEntity[] facturas) {
		return servicios.añadirFacturasServicio(servicio, facturas);
	}

	@Override
	public Integer crearServicio(ServicioEntity servicio) {
		return servicios.crearServicio(servicio);
	}



}
