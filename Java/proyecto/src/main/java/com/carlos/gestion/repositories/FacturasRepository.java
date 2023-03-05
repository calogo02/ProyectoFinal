package com.carlos.gestion.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.gestion.entities.FacturaEntity;

public interface FacturasRepository extends CrudRepository<FacturaEntity, Integer>{
    
}
