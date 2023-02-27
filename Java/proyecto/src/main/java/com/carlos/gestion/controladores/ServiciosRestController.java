package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.service.IServiceServicios;

@RestController
@RequestMapping("/v1")
public class ServiciosRestController {
	@Autowired
	IServiceServicios servicio;

	@GetMapping(value = "/servicios")
	public List<ServicioDTO> recuperarTodosLosClientes() {
		return servicio.listarTodosLosServicios();
	}

	@GetMapping(value = "/servicios/{id}")
	public ServicioDTO recuperarClientePorId(@PathVariable("id") Integer id) {
		return servicio.listarServicioPorID(id);
	}

}
