package com.carlos.funeraria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.funeraria.dao.IClientesDAO;
import com.carlos.funeraria.dto.ClienteDTO;
import com.carlos.funeraria.service.IClientesService;
@Component
public class ClientesServiceImpl implements IClientesService{
	@Autowired
	IClientesDAO clientesDAO;

	@Override
	public List<ClienteDTO> listarTodosLosClientes() {
		return clientesDAO.listarTodosLosClientes();
	}

}
