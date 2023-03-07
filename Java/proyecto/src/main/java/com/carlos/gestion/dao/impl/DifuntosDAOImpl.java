package com.carlos.gestion.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IDifuntosDAO;
import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.entities.DifuntoEntity;
import com.carlos.gestion.repositories.DifuntoRepository;


@Component
public class DifuntosDAOImpl implements IDifuntosDAO {
    @Autowired
    DifuntoRepository difuntoRepository;

    @Override
    public List<DifuntoDTO> buscarTodosLosDifuntos() {
        Iterable<DifuntoEntity> difuntos = difuntoRepository.findAll();
        List<DifuntoDTO> difuntosDTO = new ArrayList<>();
        for (DifuntoEntity difuntoEntity : difuntos) {
            difuntosDTO.add(mapperDifuntoEntityDifuntoDTO(difuntoEntity));
        }
        return difuntosDTO;
    }

    @Override
    public DifuntoDTO buscarDifuntoPorId(int id) {
        Optional<DifuntoEntity> difuntoEntity = difuntoRepository.findById(id);
        if (difuntoEntity.isPresent()) {
            return mapperDifuntoEntityDifuntoDTO(difuntoEntity.get());
        }
        return null;
    }

    @Override
    public Integer insertarDifunto(DifuntoEntity difunto) {
        try {
            difuntoRepository.save(difunto);
        } catch (Exception e) {
            return 500;
        }
        return 1;
    }

    @Override
    public Integer actualizarDifunto(Integer id ,DifuntoEntity difunto) {
        if (!difuntoRepository.existsById(id)) {
            return 404;
        }
        DifuntoEntity difuntoEntity = difuntoRepository.findById(id).get();

        try {
            difuntoEntity.setNombre(difunto.getNombre());
            difuntoEntity.setApellidos(difunto.getApellidos());
            difuntoEntity.setFechaDefuncion(difunto.getFechaDefuncion());
            difuntoEntity.setDni(difunto.getDni());
            difuntoRepository.save(difuntoEntity);
        } catch (Exception e) {
            return 500;
        }
        return 1;
    }

    @Override
    public Integer borrarDifunto(int id) {
        if (!difuntoRepository.existsById(id)) {
            return 404;
        }
        if (difuntoRepository.findById(id).get().getServicio()!=null) {
            return 500;
        }
        try {
            difuntoRepository.deleteById(id);
        } catch (Exception e) {
            return 500;
        }
        return 1;
    }

    private DifuntoDTO mapperDifuntoEntityDifuntoDTO(DifuntoEntity difuntoEntity) {
        return new DifuntoDTO(difuntoEntity.getIdDifunto(), difuntoEntity.getNombre(),
                difuntoEntity.getApellidos(), difuntoEntity.getFechaDefuncion(), difuntoEntity.getDni());
    }

}
