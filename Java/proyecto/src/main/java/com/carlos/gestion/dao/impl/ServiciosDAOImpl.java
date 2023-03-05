package com.carlos.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IServiciosDAO;
import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.entities.ServicioEntity;
import com.carlos.gestion.repositories.FacturasRepository;
import com.carlos.gestion.repositories.ServicioRespository;

@Component
public class ServiciosDAOImpl implements IServiciosDAO {
	@Autowired
	ServicioRespository servicioRespository;

	@Autowired
	FacturasRepository facturasRepository;

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

	@Override
	public List<ServicioDTO> listarServiciosConFiltros(String fecha, String velatorio, String enterramiento,
			String nombreDifunto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listarServiciosConFiltros'");
	}

	@Override
	public Integer editarServicioAdministrativo(Integer literales, Integer ultimasVoluntades, Integer idServicio) {
		try {
			Optional<ServicioEntity> servicioOptional = servicioRespository.findById(idServicio);
			if (servicioOptional.isEmpty()) {
				return 500;
			}
			ServicioEntity servicioEntity = servicioOptional.get();
			servicioEntity.setLiterales(literales);
			servicioEntity.setUltimasvoluntades(ultimasVoluntades);
			servicioRespository.save(servicioEntity);
		} catch (Exception e) {
			return 500;
		}
		return 1;
	}

	@Override
	public Integer editarServicioGestor(Integer id, ServicioEntity servicio) {
		try {

			Optional<ServicioEntity> servicioOptional = servicioRespository.findById(id);
			if (servicioOptional.isEmpty()) {
				return 500;
			}
			if (servicio.getDifunto() == null) {
				servicio.setDifunto(servicioOptional.get().getDifunto());
			}
			ServicioEntity servicioEntity = servicioOptional.get();
			servicioEntity.setFechaServicio(servicio.getFechaServicio());
			servicioEntity.setVelatorio(servicio.getVelatorio());
			servicioEntity.setEnterramiento(servicio.getEnterramiento());
			servicioEntity.setDifunto(servicio.getDifunto());
			servicioRespository.save(servicioEntity);
		} catch (Exception e) {
			return 500;
		}
		return 1;
	}

	@Override
	public Integer añadirFacturasServicio(Integer servicio, FacturaEntity[] facturas) {
		try	{
			Optional<ServicioEntity> servicioOptional = servicioRespository.findById(servicio);
			if (servicioOptional.isEmpty()) {
				return 500;
			}
			for (FacturaEntity facturaEntity : facturas) {
				facturaEntity.setServicio(servicioOptional.get());
			}
			facturasRepository.saveAll(List.of(facturas));
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
		return 1;
	}

	@Override
	public Integer crearServicio(ServicioEntity servicio) {
		try {
			if (servicio.getDifunto() == null) {
				throw new Exception("El servicio no tiene difunto");
			}
			servicio.setLiterales(0);
			servicio.setUltimasvoluntades(0);
			servicioRespository.save(servicio);
		} catch (Exception e) {
			return 500;
		}
		return 1;
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
