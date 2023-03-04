package com.carlos.gestion.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carlos.gestion.entities.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
	@Query("SELECT c FROM ClienteEntity c WHERE c.id like concat('%',:id,'%') "
			+ "AND c.nombre like concat('%',:nombre,'%') "
			+ "AND c.apellidos like concat('%',:apellidos,'%') "
			+ "AND c.regimenFiscal like concat('%',:regimenfiscal,'%') "
			+ "AND c.direccion like concat('%',:direccion,'%') "
			+ "AND c.metodoDePago like concat('%',:metododepago,'%')")
	Iterable<ClienteEntity> findClientesByFiltros(@Param("id") String id, @Param("nombre") String nombre,
			@Param("apellidos") String apellidos, @Param("regimenfiscal") String regimenfiscal,
			@Param("direccion") String direccion, @Param("metododepago") String metododepago);

}
