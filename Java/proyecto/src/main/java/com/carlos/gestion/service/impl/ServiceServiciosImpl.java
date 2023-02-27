package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IServiciosDAO;
import com.carlos.gestion.dto.ServicioDTO;
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
	public ServicioDTO listarServicioPorID(Integer id) {
		return servicios.listarServicioPorId(id);
	}

}
