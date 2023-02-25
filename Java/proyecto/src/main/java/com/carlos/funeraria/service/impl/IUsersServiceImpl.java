package com.carlos.funeraria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.carlos.funeraria.dao.IUsersDAO;
import com.carlos.funeraria.entities.UserEntity;
import com.carlos.funeraria.service.IUsersService;

@Component
public class IUsersServiceImpl implements IUsersService{
	@Autowired
	IUsersDAO usersDAO;
	
	@Override
	public String registerUser(UserEntity nuevoUsuario) {
		return usersDAO.registerUser(nuevoUsuario);
	}

}
