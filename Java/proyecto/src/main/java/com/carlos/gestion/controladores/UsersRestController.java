package com.carlos.gestion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.gestion.entities.UserEntity;
import com.carlos.gestion.service.IUsersService;


@RestController
@CrossOrigin
public class UsersRestController {
	@Autowired
	IUsersService usersService;
	
	@PostMapping(value = "/registro")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity nuevoUsuario) {
		try {
			usersService.registerUser(nuevoUsuario);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error Durante el registro", HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		return new ResponseEntity<>("Registro Completado", HttpStatus.OK);		
	}
	@GetMapping(value = "/user/logincheck")
	public ResponseEntity<String> loginUserValid() {
		return new ResponseEntity<>("Login Completado", HttpStatus.OK);		
	}
	@PostMapping(value = "/user/loginfail")
	public ResponseEntity<String> loginUserFail() {
		return new ResponseEntity<>("Login Fallido", HttpStatus.FORBIDDEN);		
	}

}
