package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.FacturasDTO;
import com.carlos.gestion.entities.FacturaEntity;
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

    @GetMapping(value = "/facturas", params = { "nombreCliente", "apellidosCliente", "dniCliente", "nombreDifunto",
            "apellidosDifunto",
            "dniDifunto", "precioFactura", "idTipoServicio", "fechaFactura" })
    public List<FacturasDTO> getFacturasConFiltros(
            @RequestParam(name = "nombreCliente", defaultValue = "") String nombreCliente,
            @RequestParam(name = "apellidosCliente", defaultValue = "") String apellidosCliente,
            @RequestParam(name = "dniCliente", defaultValue = "") String dniCliente,
            @RequestParam(name = "nombreDifunto", defaultValue = "") String nombreDifunto,
            @RequestParam(name = "apellidosDifunto", defaultValue = "") String apellidosDifunto,
            @RequestParam(name = "dniDifunto", defaultValue = "") String dniDifunto,
            @RequestParam(name = "precioFactura", defaultValue = "0.0") String precioFactura,
            @RequestParam(name = "idTipoServicio", defaultValue = "") String idTipoServicio,
            @RequestParam(name = "fechaFactura", defaultValue = "1000/01/01") String fechaFactura) {
        return facturasService.recuperarFacturasConFiltros(nombreCliente, apellidosCliente, dniCliente, nombreDifunto,
                apellidosDifunto, dniDifunto, Double.parseDouble(precioFactura), idTipoServicio, fechaFactura);
    }

    @PostMapping("/facturas")
    public ResponseEntity<String> insertarFactura(@RequestBody FacturaEntity factura) {
        Integer resultado = facturasService.insertarFactura(factura);
        if (resultado == 500) {
            return ResponseEntity.status(500).body("Error al insertar la factura");
        }
        return ResponseEntity.ok().body("Factura insertada correctamente");
    }

    @PutMapping("/facturas/{id}")
    public ResponseEntity<String> modificarFactura(@PathVariable("id") Integer id, @RequestBody FacturaEntity factura) {
        Integer resultado = facturasService.modificarFactura(id, factura);
        if (resultado == 500) {
            return ResponseEntity.status(500).body("Error al actualizar la factura");
        }
        if (resultado == 404) {
            return ResponseEntity.status(404).body("No se ha encontrado la factura");
        }
        return ResponseEntity.ok().body("Factura actualizada correctamente");
    }
}
