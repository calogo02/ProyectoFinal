package com.carlos.gestion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.entities.FacturaEntity;
import com.carlos.gestion.entities.ServicioEntity;
import com.carlos.gestion.service.IServiceServicios;

@RestController
@RequestMapping("/v2")
public class ServiciosRestControllerGestor {
    @Autowired
    private IServiceServicios servicios;

    @PatchMapping("/servicios/{id}")
    public ResponseEntity<String> añadirFacturasServicio(@PathVariable Integer id,
            @RequestBody FacturaEntity[] facturas) {
        Integer resultado = servicios.añadirFacturasServicio(id, facturas);
        if (resultado == 1) {
            return ResponseEntity.ok("Facturas añadidas correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se han podido añadir las facturas");
        }

    }

    @PostMapping(value = "/servicios")
    public ResponseEntity<String> crearServicio(@RequestBody ServicioEntity servicioEntity) {
        if (servicios.crearServicio(servicioEntity) == 1) {
            return ResponseEntity.ok("Servicio creado correctamente");
        }
        return ResponseEntity.badRequest().body("No se ha podido crear el servicio");
    }

    @PutMapping(value = "/servicios/{id}")
    public ResponseEntity<String> editarServicioGestor(@PathVariable("id") Integer id,
            @RequestBody ServicioEntity servicioEntity) {
        if (servicios.editarServicioGestor(id ,servicioEntity) == 1) {
            return ResponseEntity.ok("Servicio editado correctamente");
        }
        return ResponseEntity.badRequest().body("No se ha podido editar el servicio");
    }

}
