package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IFacturasDAO;
import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.service.IFacturasService;

@Component
public class FacturasServiceImpl implements IFacturasService {
    @Autowired
    private IFacturasDAO facturasDAO;

    @Override
    public List<FacturasDTO> recuperarTodasLasFacturas() {
        return facturasDAO.recuperarTodasLasFacturas();
    }

    @Override
    public FacturasDTO recuperarFacturaPorId(Integer idFactura) {
        return facturasDAO.recuperarFacturaPorId(idFactura);
    }

    @Override
    public List<FacturasDTO> recuperarFacturasConFiltros(String nombreCliente, String apellidosCliente,
            String dniCliente, String nombreDifunto, String apellidosDifunto, String dniDifunto, Double precioFactura,
            String idTipoServicio, String fechaFactura) {
                return facturasDAO.recuperarFacturasConFiltros(nombreCliente, apellidosCliente, dniCliente, nombreDifunto, apellidosDifunto, dniDifunto, precioFactura, idTipoServicio, fechaFactura);
    }

    @Override
    public Integer insertarFactura(FacturaEntity factura) {
        return facturasDAO.insertarFactura(factura);
    }

    @Override
    public Integer modificarFactura(Integer idFactura, FacturaEntity factura) {
        return facturasDAO.modificarFactura(idFactura, factura);
    }

}
