package com.carlos.gestion.service;

import java.util.List;

import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.entities.ClienteEntity;

public interface IClientesService {
	List<ClienteDTO> listarTodosLosClientes();
	List<ClienteDTO> listarClientesporId(int id);
	List<ClienteDTO> listarClientesConFiltros(String id ,String nombre, String apellidos, String regimenFiscal , String direccion, String metodoPago);

	Integer insertarCliente(ClienteEntity cliente);
	Integer actualizarCliente(ClienteEntity cliente, int id);
	Integer eliminarCliente(int id);

}
