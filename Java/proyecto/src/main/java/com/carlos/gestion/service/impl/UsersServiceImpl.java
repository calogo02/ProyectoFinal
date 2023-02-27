package com.carlos.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IUsersDAO;
import com.carlos.gestion.entities.UserEntity;
import com.carlos.gestion.service.IUsersService;

@Component
public class UsersServiceImpl implements IUsersService{
	@Autowired
	IUsersDAO usersDAO;
	
	@Override
	public String registerUser(UserEntity nuevoUsuario) {
		return usersDAO.registerUser(nuevoUsuario);
	}

}
