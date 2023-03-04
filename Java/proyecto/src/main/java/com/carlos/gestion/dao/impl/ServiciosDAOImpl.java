package com.carlos.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IServiciosDAO;
import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.entities.ServicioEntity;
import com.carlos.gestion.repositories.ServicioRespository;

@Component
public class ServiciosDAOImpl implements IServiciosDAO {
	@Autowired
	ServicioRespository servicioRespository;

	@Override
	public List<ServicioDTO> listarTodosLosServicios() {
		List<ServicioDTO> listaServicioDTOs = new ArrayList<>();
		Iterable<ServicioEntity> listaServicios = servicioRespository.findAll();
		for (ServicioEntity servicioEntity : listaServicios) {

			listaServicioDTOs.add(mapperServicioEntityServicioDTO(servicioEntity));
		}

		return listaServicioDTOs;
	}
	@Override
	public ServicioDTO listarServicioPorId(Integer id) {
		Optional<ServicioEntity> servicioOptional = servicioRespository.findById(id);
		if (servicioOptional.isEmpty()) {
			return null;
		}
		ServicioEntity servicioEntity = servicioOptional.get();
		return mapperServicioEntityServicioDTO(servicioEntity);
	}
	private ServicioDTO mapperServicioEntityServicioDTO(ServicioEntity servicioEntity) {
		DifuntoDTO difuntoServicio = new DifuntoDTO(servicioEntity.getDifunto().getIdDifunto(),
				servicioEntity.getDifunto().getNombre(), servicioEntity.getDifunto().getNombre(),
				servicioEntity.getDifunto().getFechaDefuncion(), servicioEntity.getDifunto().getDni());

		ServicioDTO servicio = new ServicioDTO(servicioEntity.getIdServicio(), servicioEntity.getFechaServicio(),
				servicioEntity.getVelatorio(), servicioEntity.getEnterramiento(), difuntoServicio,
				servicioEntity.getLiterales(), servicioEntity.getUltimasvoluntades());
		return servicio;
	}

}
