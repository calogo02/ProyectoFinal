package com.carlos.gestion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.entities.DifuntoEntity;
import com.carlos.gestion.service.IDifuntosService;

@RestController
@RequestMapping("/v1")
public class DifuntosRestController {
    @Autowired
    IDifuntosService difuntosService;

    @GetMapping("/difuntos")
    public List<DifuntoDTO> getDifuntos() {
        return difuntosService.buscarTodosLosDifuntos();
    }

    @GetMapping("/difuntos/{id}")
    public DifuntoDTO getDifunto(@PathVariable Integer id) {
        return difuntosService.buscarDifuntoPorId(id);
    }

    @PostMapping("/difuntos")
    public ResponseEntity<String> crearDifunto(@RequestBody DifuntoEntity difunto) {
        Integer response = difuntosService.insertarDifunto(difunto);
        if (response == 500) {
            return ResponseEntity.status(500).body("Error al insertar el difunto");
        }
        return ResponseEntity.status(201).body("Difunto insertado correctamente");
    }

    @PutMapping("/difuntos/{id}")
    public ResponseEntity<String> actualizarDifunto(@RequestBody DifuntoEntity difunto, @PathVariable Integer id) {
        Integer response = difuntosService.actualizarDifunto(id, difunto);
        if (response == 404) {
            return ResponseEntity.status(404).body("No se ha encontrado el difunto");
        }
        if (response == 500) {
            return ResponseEntity.status(500).body("Error al actualizar el difunto");
        }
        return ResponseEntity.status(200).body("Difunto actualizado correctamente");
    }

    @DeleteMapping("/difuntos/{id}")
    public ResponseEntity<String> borrarDifunto(@PathVariable Integer id) {
        Integer response = difuntosService.borrarDifunto(id);
        if (response == 404) {
            return ResponseEntity.status(404).body("No se ha encontrado el difunto");
        }
        if (response == 500) {
            return ResponseEntity.status(500).body("Error al borrar el difunto");
        }
        return ResponseEntity.status(200).body("Difunto borrado correctamente");
    }

}
