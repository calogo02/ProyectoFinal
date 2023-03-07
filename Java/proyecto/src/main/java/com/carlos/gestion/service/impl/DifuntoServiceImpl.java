package com.carlos.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IDifuntosDAO;
import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.entities.DifuntoEntity;
import com.carlos.gestion.service.IDifuntosService;

@Component
public class DifuntoServiceImpl implements IDifuntosService {
    @Autowired
    IDifuntosDAO difuntosDAO;

    @Override
    public List<DifuntoDTO> buscarTodosLosDifuntos() {
        return difuntosDAO.buscarTodosLosDifuntos();
    }

    @Override
    public DifuntoDTO buscarDifuntoPorId(int id) {
        return difuntosDAO.buscarDifuntoPorId(id);
    }

    @Override
    public Integer insertarDifunto(DifuntoEntity difunto) {
        return difuntosDAO.insertarDifunto(difunto);
    }

    @Override
    public Integer actualizarDifunto(Integer id,DifuntoEntity difunto) {
        return difuntosDAO.actualizarDifunto(id, difunto);
    }

    @Override
    public Integer borrarDifunto(int id) {
        return difuntosDAO.borrarDifunto(id);
    }

}
