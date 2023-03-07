package com.carlos.gestion.dao;

import java.util.List;

import com.carlos.gestion.dto.DifuntoDTO;
import com.carlos.gestion.entities.DifuntoEntity;

public interface IDifuntosDAO {

    public List<DifuntoDTO> buscarTodosLosDifuntos();
    public DifuntoDTO buscarDifuntoPorId(int id);

    public Integer insertarDifunto(DifuntoEntity difunto);
    public Integer actualizarDifunto(Integer id ,DifuntoEntity difunto);
    public Integer borrarDifunto(int id);
    
}
