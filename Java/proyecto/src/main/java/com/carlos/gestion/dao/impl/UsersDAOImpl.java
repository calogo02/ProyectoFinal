package com.carlos.gestion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.carlos.gestion.dao.IUsersDAO;
import com.carlos.gestion.entities.AuthoritiesEntity;
import com.carlos.gestion.entities.UserEntity;
import com.carlos.gestion.repositories.AuthorityRepository;
import com.carlos.gestion.repositories.UsersRepository;

@Component
public class UsersDAOImpl implements IUsersDAO {
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public String registerUser(UserEntity nuevoUsuario) {
		AuthoritiesEntity autoridadPorDefecto = new AuthoritiesEntity(nuevoUsuario.getUsername(),
				"ROLE_ADMINISTRATIVO");
		nuevoUsuario.setEnabled(1);
		nuevoUsuario.setPassword(getPasswordCifrada(nuevoUsuario.getPassword()));
		usersRepository.save(nuevoUsuario);
		authorityRepository.save(autoridadPorDefecto);
		return nuevoUsuario.getUsername();
	}

	private String getPasswordCifrada(String passWord) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(passWord);
		System.out.println(encoder.encode(passWord));

		System.out.println(encoder.matches(passWord, encoder.encode(passWord)));
		return encoder.encode(passWord);

	}

}
