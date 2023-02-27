package com.carlos.gestion.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.gestion.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, String>{

}
