package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IClientesDAO;
import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.service.IClientesService;
@Component
public class ClientesServiceImpl implements IClientesService{
	@Autowired
	IClientesDAO clientesDAO;

	@Override
	public List<ClienteDTO> listarTodosLosClientes() {
		return clientesDAO.listarTodosLosClientes();
	}

}
