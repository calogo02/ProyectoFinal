package com.carlos.funeraria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.funeraria.entities.AuthoritiesEntity;

public interface AuthorityRepository extends CrudRepository<AuthoritiesEntity, String>{

}
