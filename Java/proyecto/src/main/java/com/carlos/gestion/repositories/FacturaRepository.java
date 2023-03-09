package com.carlos.gestion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carlos.gestion.entities.FacturaEntity;

public interface FacturaRepository extends CrudRepository<FacturaEntity, Integer> {

    @Query("SELECT f FROM FacturaEntity f WHERE f.cliente.nombre like concat('%',:nombreCliente,'%') "
            + "AND f.cliente.apellidos like concat('%',:apellidosCliente,'%') "
            + "AND f.cliente.dni like concat('%',:dniCliente,'%') "
            + "AND f.servicio.difunto.nombre like concat('%',:nombreDifunto,'%') "
            + "AND f.servicio.difunto.apellidos like concat('%',:apellidosDifunto,'%') "
            + "AND f.servicio.difunto.dni like concat('%',:dniDifunto,'%') "
            + "AND f.precioTotal >= :precioFactura "
            + "AND f.categoria.id like concat('%',:idTipoServicio,'%') "
            + "AND f.servicio.fechaServicio >= :fechaFactura")
    Iterable<FacturaEntity> recuperarFacturasConFiltros(@Param("nombreCliente") String nombreCliente,
            @Param("apellidosCliente") String apellidosCliente, @Param("dniCliente") String dniCliente,
            @Param("nombreDifunto") String nombreDifunto, @Param("apellidosDifunto") String apellidosDifunto,
            @Param("dniDifunto") String dniDifunto, @Param("precioFactura") Double precioFactura,
            @Param("idTipoServicio") String idTipoServicio, @Param("fechaFactura") String fechaFactura);

}
