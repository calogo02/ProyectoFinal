package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IClientesDAO;
import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.entities.ClienteEntity;
import com.carlos.gestion.service.IClientesService;
@Component
public class ClientesServiceImpl implements IClientesService{
	@Autowired
	IClientesDAO clientesDAO;

	@Override
	public List<ClienteDTO> listarTodosLosClientes() {
		return clientesDAO.listarTodosLosClientes();
	}

	@Override
	public List<ClienteDTO> listarClientesporId(int id) {
		return clientesDAO.listarClientesporId(id);
	}

	@Override
	public List<ClienteDTO> listarClientesConFiltros(String id, String nombre, String apellidos, String regimenFiscal,
			String direccion, String metodoPago) {
		return clientesDAO.listarClientesConFiltros(id, nombre, apellidos, regimenFiscal, direccion, metodoPago);
	}

	@Override
	public Integer insertarCliente(ClienteEntity cliente) {
		return clientesDAO.insertarCliente(cliente);
	}

	@Override
	public Integer actualizarCliente(ClienteEntity cliente, int id) {
		return clientesDAO.actualizarCliente(cliente, id);
	}

	@Override
	public Integer eliminarCliente(int id) {
		return clientesDAO.eliminarCliente(id);
	}

}
