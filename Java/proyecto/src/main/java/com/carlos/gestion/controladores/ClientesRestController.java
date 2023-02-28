package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.service.IClientesService;

@RestController
public class ClientesRestController {
	@Autowired
	IClientesService clientesService;
	
	@GetMapping(value = "/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		
		System.out.println("prueba");
		return clientesService.listarTodosLosClientes();
	}

}
