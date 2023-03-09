package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.service.IFacturasService;

@RestController
@RequestMapping("/v1")
public class FacturasRestController {
    @Autowired
    IFacturasService facturasService;

    @GetMapping("/facturas")
    public List<FacturasDTO> getFacturas() {
        return facturasService.recuperarTodasLasFacturas();
    }
    @GetMapping("/facturas/{id}")
    public FacturasDTO getFacturaPorID(@PathVariable("id") Integer id) {
        return facturasService.recuperarFacturaPorId(id);
    }
	@GetMapping(value = "/facturas", params = { "nombreCliente", "apellidosCliente", "dniCliente", "nombreDifunto", "apellidosDifunto",
			"dniDifunto", "precioFactura","idTipoServicio", "fechaFactura" })
    public List<FacturasDTO> getFacturasConFiltros(@RequestParam(name = "nombreCliente", defaultValue = "") String nombreCliente,
    		@RequestParam(name = "apellidosCliente", defaultValue = "") String apellidosCliente,
    		@RequestParam(name = "dniCliente", defaultValue = "") String dniCliente,
    		@RequestParam(name = "nombreDifunto", defaultValue = "") String nombreDifunto,
    		@RequestParam(name = "apellidosDifunto", defaultValue = "") String apellidosDifunto,
    		@RequestParam(name = "dniDifunto", defaultValue = "") String dniDifunto,
    		@RequestParam(name = "precioFactura", defaultValue = "") String precioFactura,
    		@RequestParam(name = "idTipoServicio", defaultValue = "") String idTipoServicio,
    		@RequestParam(name = "fechaFactura", defaultValue = "") String fechaFactura) {
        return facturasService.recuperarFacturasConFiltros(nombreCliente, apellidosCliente, dniCliente, nombreDifunto, apellidosDifunto, dniDifunto, Double.parseDouble(precioFactura), idTipoServicio, fechaFactura);
    }            

}
