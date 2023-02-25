package com.carlos.funeraria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.funeraria.entities.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, String>{

}
