package com.carlos.funeraria.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.funeraria.dao.IUsersDAO;
import com.carlos.funeraria.entities.AuthoritiesEntity;
import com.carlos.funeraria.entities.UserEntity;
import com.carlos.funeraria.repositories.AuthorityRepository;
import com.carlos.funeraria.repositories.UsersRepository;

@Component
public class UsersDAOImpl implements IUsersDAO{
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Override
	public String registerUser(UserEntity nuevoUsuario) {
		AuthoritiesEntity autoridadPorDefecto = new AuthoritiesEntity(nuevoUsuario.getUsername(), "ROLE_ADMINISTRATIVO");
		usersRepository.save(nuevoUsuario);
		authorityRepository.save(autoridadPorDefecto);
		return nuevoUsuario.getUsername();
	}

}
