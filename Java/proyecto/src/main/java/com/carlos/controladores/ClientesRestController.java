package com.carlos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.funeraria.dto.ClienteDTO;

@RestController
@RequestMapping("/v1")
public class ClientesRestController {
	@Autowired
	
	@GetMapping(value = "/clientes")
	public List<ClienteDTO> recuperarTodosLosClientes() {
		return null;
	}

}
