package com.carlos.funeraria.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.funeraria.dao.IClientesDAO;
import com.carlos.funeraria.dto.ClienteDTO;
import com.carlos.funeraria.dto.FacturasDTO;
import com.carlos.funeraria.dto.RegimenFiscalDTO;
import com.carlos.funeraria.entities.ClienteEntity;
import com.carlos.funeraria.entities.FacturaEntity;
import com.carlos.funeraria.repositories.ClienteRepository;

@Component
public class ClientesDAOImpl implements IClientesDAO {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> listarTodosLosClientes() {
		List<ClienteDTO> listaClientesDTO = new ArrayList<>();
		Iterable<ClienteEntity> listaClientes = clienteRepository.findAll();
		for (ClienteEntity clienteEntity : listaClientes) {
			RegimenFiscalDTO regimenFiscal = new RegimenFiscalDTO(clienteEntity.getRegimenFiscal().getId(),
					clienteEntity.getRegimenFiscal().getNombre(), clienteEntity.getRegimenFiscal().getDescripcion());
			List<FacturasDTO> listaFacturasCliente = new ArrayList<>();
			for (FacturaEntity factura : clienteEntity.getListaFacturas()) {
				FacturasDTO nuevaFactura = new FacturasDTO(factura.getIdFactura(), factura.getCategoria().getId(), factura.getCategoria().getNombre());
				listaFacturasCliente.add(nuevaFactura);
			}
			ClienteDTO nuevoCliente = new ClienteDTO(clienteEntity.getIdCliente(), clienteEntity.getNombre(),
					clienteEntity.getApellidos(), regimenFiscal, clienteEntity.getDireccion(),
					clienteEntity.getMetodoDePago(), listaFacturasCliente);
			listaClientesDTO.add(nuevoCliente);
		}
		return listaClientesDTO;
	}

}
