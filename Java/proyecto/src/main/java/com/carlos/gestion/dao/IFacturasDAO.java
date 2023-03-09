package com.carlos.gestion.dao;

import java.util.List;

import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.entities.FacturaEntity;

public interface IFacturasDAO {

    public List<FacturasDTO> recuperarTodasLasFacturas();

    public FacturasDTO recuperarFacturaPorId(Integer idFactura);

    public List<FacturasDTO> recuperarFacturasConFiltros(String nombreCliente, String apellidosCliente,
            String dniCliente, String nombreDifunto, String apellidosDifunto, String dniDifunto, Double precioFactura,
            String idTipoServicio, String fechaFactura);

    public Integer insertarFactura(FacturaEntity factura);
    public Integer modificarFactura(Integer idFactura, FacturaEntity factura);


}
