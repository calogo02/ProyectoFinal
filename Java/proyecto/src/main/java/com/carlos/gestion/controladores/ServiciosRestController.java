package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.ServicioDTO;
import com.carlos.gestion.entities.ServicioEntity;
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
		return servicio.listarServicioPorId(id);
	}

	@GetMapping(value = "/servicios", params = { "fecha", "velatorio", "enterramiento", "nombreDifunto" })
	public List<ServicioDTO> recuperarServiciosConFiltros(
			@RequestParam(name = "fecha", defaultValue = "1000-01-01") String fecha,
			@RequestParam(name = "velatorio", defaultValue = "") String velatorio,
			@RequestParam(name = "enterramiento", defaultValue = "") String enterramiento,
			@RequestParam(name = "nombreDifunto", defaultValue = "") String nombreDifunto) {
		return servicio.listarServiciosConFiltros(fecha,nombreDifunto, velatorio, enterramiento);
	}

	@PutMapping(value = "/servicios/{id}")
	public ResponseEntity<String> editarServicioAdministrativo(@PathVariable("id") Integer id,
			@RequestBody ServicioEntity servicioEntity) {
		if (servicio.editarServicioAdministrativo(servicioEntity.getLiterales(), servicioEntity.getUltimasvoluntades(),
				id) == 1) {
			return ResponseEntity.ok("Servicio editado correctamente");
		}
		return ResponseEntity.badRequest().body("No se ha podido editar el servicio");
	}
}
