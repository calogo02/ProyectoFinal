package com.carlos.gestion.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.gestion.entities.AuthoritiesEntity;

public interface AuthorityRepository extends CrudRepository<AuthoritiesEntity, String>{

}
