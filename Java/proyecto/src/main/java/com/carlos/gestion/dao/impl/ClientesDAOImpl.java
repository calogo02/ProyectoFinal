package com.carlos.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IClientesDAO;
import com.carlos.gestion.dto.ClienteDTO;
import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.dto.RegimenFiscalDTO;
import com.carlos.gestion.entities.ClienteEntity;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.repositories.ClienteRepository;

@Component
public class ClientesDAOImpl implements IClientesDAO {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> listarTodosLosClientes() {
		List<ClienteDTO> listaClientesDTO = new ArrayList<>();
		Iterable<ClienteEntity> listaClientes = clienteRepository.findAll();
		for (ClienteEntity clienteEntity : listaClientes) {
			listaClientesDTO.add(mapperClienteEntityClienteDto(clienteEntity));
		}
		return listaClientesDTO;
	}

	@Override
	public List<ClienteDTO> listarClientesporId(int id) {
		List<ClienteDTO> listaClientesDTO = new ArrayList<>();
		Optional<ClienteEntity> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			listaClientesDTO.add(mapperClienteEntityClienteDto(clienteOptional.get()));
		}
		return listaClientesDTO;
	}

	@Override
	public Integer insertarCliente(ClienteEntity cliente) {
		try {
			clienteRepository.save(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
		return 1;
	}

	@Override
	public Integer actualizarCliente(ClienteEntity cliente, int id) {
		try {
			ClienteEntity clienteEntity = clienteRepository.findById(id).get();
			clienteEntity.setNombre(cliente.getNombre());
			clienteEntity.setApellidos(cliente.getApellidos());
			clienteEntity.setDireccion(cliente.getDireccion());
			clienteEntity.setMetodoDePago(cliente.getMetodoDePago());
			clienteRepository.save(clienteEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
		return 1;
	}

	@Override
	public Integer eliminarCliente(int id) {
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}
		return 1;
	}

	private ClienteDTO mapperClienteEntityClienteDto(ClienteEntity clienteEntity) {
		RegimenFiscalDTO regimenFiscal = new RegimenFiscalDTO(clienteEntity.getRegimenFiscal().getId(),
				clienteEntity.getRegimenFiscal().getNombre(), clienteEntity.getRegimenFiscal().getDescripcion());
		List<FacturasDTO> listaFacturasCliente = new ArrayList<>();
		for (FacturaEntity factura : clienteEntity.getListaFacturas()) {
			FacturasDTO nuevaFactura = new FacturasDTO(factura.getIdFactura(), factura.getCategoria().getId(),
					factura.getCategoria().getNombre());
			listaFacturasCliente.add(nuevaFactura);
		}
		ClienteDTO nuevoCliente = new ClienteDTO(clienteEntity.getIdCliente(), clienteEntity.getNombre(),
				clienteEntity.getApellidos(), regimenFiscal, clienteEntity.getDireccion(),
				clienteEntity.getMetodoDePago(), listaFacturasCliente);
		return nuevoCliente;
	}

	@Override
	public List<ClienteDTO> listarClientesConFiltros(String id, String nombre, String apellidos, String regimenFiscal,
			String direccion, String metodoPago) {
		List<ClienteDTO> listaClientesDTO = new ArrayList<>();
		Iterable<ClienteEntity> listaClientes = clienteRepository.findClientesByFiltros(id, nombre, apellidos,
				regimenFiscal, direccion, metodoPago);
		for (ClienteEntity clienteEntity : listaClientes) {
			listaClientesDTO.add(mapperClienteEntityClienteDto(clienteEntity));
		}
		return listaClientesDTO;
	}
}
