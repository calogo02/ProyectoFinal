package com.carlos.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IFacturasDAO;
import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.repositories.FacturaRepository;


@Component
public class FacturasDAOImpl implements IFacturasDAO {
    @Autowired
    private FacturaRepository facturaRepository;
    
    @Override
    public List<FacturasDTO> recuperarTodasLasFacturas() {
        Iterable<FacturaEntity> facturasEntity = facturaRepository.findAll();
        List<FacturasDTO> facturasDTO = new ArrayList<>();
        for (FacturaEntity facturaEntity : facturasEntity) {
            facturasDTO.add(mapperFacturaEntityFacturasDTO(facturaEntity));
        }
        return  facturasDTO;

    }

    @Override
    public FacturasDTO recuperarFacturaPorId(Integer idFactura) {
        Optional<FacturaEntity> facturaEntity = facturaRepository.findById(idFactura);
        if (facturaEntity.isPresent()) {
            return mapperFacturaEntityFacturasDTO(facturaEntity.get());
        }
        return null;
    }

    @Override
    public List<FacturasDTO> recuperarFacturasConFiltros(String nombreCliente, String apellidosCliente,
            String dniCliente, String nombreDifunto, String apellidosDifunto, String dniDifunto, Double precioFactura,
            String idTipoServicio, String fechaFactura) {
            Iterable<FacturaEntity> facturasEntity = facturaRepository.recuperarFacturasConFiltros(nombreCliente, apellidosCliente, dniCliente, nombreDifunto, apellidosDifunto, dniDifunto, precioFactura, idTipoServicio, fechaFactura);
            List<FacturasDTO> facturasDTO = new ArrayList<>();
            for (FacturaEntity facturaEntity : facturasEntity) {
                facturasDTO.add(mapperFacturaEntityFacturasDTO(facturaEntity));
            }
            return  facturasDTO;
        }

    @Override
    public Integer insertarFactura(FacturaEntity factura) {
        try {
            facturaRepository.save(factura);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Integer modificarFactura(Integer idFactura, FacturaEntity factura) {
        if (!facturaRepository.existsById(idFactura)) {
            return 404;
        }
        FacturaEntity facturaEntityModificar = facturaRepository.findById(idFactura).get();
        facturaEntityModificar.setCategoria(factura.getCategoria());
        facturaEntityModificar.setCliente(factura.getCliente());
        try {
            facturaRepository.save(facturaEntityModificar);
            return 1;
        } catch (Exception e) {
            return 500;
        }




    }

    private FacturasDTO mapperFacturaEntityFacturasDTO(FacturaEntity facturaEntity) {
        return new FacturasDTO(facturaEntity.getIdFactura(), facturaEntity.getCategoria().getId(),
                facturaEntity.getCategoria().getNombre());
    }

}
