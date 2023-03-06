package com.carlos.gestion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carlos.gestion.entities.ServicioEntity;

public interface ServicioRespository extends CrudRepository<ServicioEntity, Integer> {

    @Query("SELECT s FROM ServicioEntity s WHERE "
            + "s.difunto.nombre like concat('%',:nombre,'%') "
            + "AND s.velatorio like concat('%',:velatorio,'%') "
            + "AND s.enterramiento like concat('%',:enterramiento,'%') "
            + "AND s.fechaServicio >= :fecha")
    Iterable<ServicioEntity> findServiciosByFiltros(@Param("fecha") String fechaServicio, @Param("nombre") String nombreDifunto,
    @Param("velatorio") String velatorio, 
    @Param("enterramiento") String enterramiento);

}
