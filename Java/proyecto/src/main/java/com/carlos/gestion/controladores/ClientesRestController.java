package com.carlos.funeraria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.funeraria.dto.ClienteDTO;
import com.carlos.funeraria.service.IClientesService;

@RestController
public class ClientesRestController {
	@Autowired
	IClientesService clientesService;
	
	@GetMapping(value = "/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		return clientesService.listarTodosLosClientes();
	}

}
