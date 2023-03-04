package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.entities.ClienteEntity;
import com.carlos.gestion.service.IClientesService;

@RestController
@RequestMapping("/v1")
public class ClientesRestController {
	@Autowired
	IClientesService clientesService;

	@GetMapping(value = "/clientes", params = { "id", "nombre", "apellidos", "regimenFiscal", "direccion",
			"metodoPago" })
	public List<ClienteDTO> recuperarClienteConFiltros(@RequestParam(name = "id", defaultValue = "") String id,
			@RequestParam(name = "nombre", defaultValue = "") String nombre,
			@RequestParam(name = "apellidos", defaultValue = "") String apellidos,
			@RequestParam(name = "regimenFiscal", defaultValue = "") String regimenFiscal,
			@RequestParam(name = "direccion", defaultValue = "") String direccion,
			@RequestParam(name = "metodoPago", defaultValue = "") String metodoPago) {
		return clientesService.listarClientesConFiltros(id, nombre, apellidos, regimenFiscal, direccion, metodoPago);
	}

	@GetMapping(value = "/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		return clientesService.listarTodosLosClientes();
	}

	@GetMapping(value = "/clientes/{id}")
	public List<ClienteDTO> recuperarClientePorId(@PathVariable("id") Integer id) {
		return clientesService.listarClientesporId(id);
	}

	@PostMapping(value = "/clientes")
	public ResponseEntity<String> InsertarCliente(@RequestBody ClienteEntity cliente) {
		try {
			if (clientesService.insertarCliente(cliente) == 500) {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error al insertar el cliente");
		}
		return ResponseEntity.ok("Cliente insertado correctamente");

	}

	@PutMapping(value = "/clientes/{id}")
	public ResponseEntity<String> actualizarCliente(@RequestBody ClienteEntity cliente,
			@PathVariable("id") Integer id) {
		try {
			if (clientesService.actualizarCliente(cliente, id) == 500) {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error al actualizar el cliente");
		}
		return ResponseEntity.ok("Cliente actualizado correctamente");
	}

	@DeleteMapping(value = "/clientes/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable("id") Integer id) {
		try {
			if (clientesService.eliminarCliente(id) == 500) {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error al eliminar el cliente");
		}
		return ResponseEntity.ok("Cliente eliminado correctamente");
	}

}
