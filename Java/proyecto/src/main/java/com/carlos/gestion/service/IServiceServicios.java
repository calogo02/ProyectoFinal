package com.carlos.gestion.service;

import java.util.List;

import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.entities.ServicioEntity;

public interface IServiceServicios {

	public List<ServicioDTO> listarTodosLosServicios();
	public ServicioDTO listarServicioPorId(Integer id);
	public List<ServicioDTO> listarServiciosConFiltros(String fecha, String velatorio , String enterramiento, String nombreDifunto);

	public Integer editarServicioAdministrativo(Integer literales, Integer ultimasVoluntades, Integer idServicio);
	public Integer editarServicioGestor(Integer id ,ServicioEntity servicio);

	public Integer añadirFacturasServicio(Integer servicio , FacturaEntity[] facturas);

	public Integer crearServicio(ServicioEntity servicio);
	

	

}
