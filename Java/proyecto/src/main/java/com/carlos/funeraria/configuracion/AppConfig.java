package com.carlos.funeraria.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan("com")
public class AppConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder password = new BCryptPasswordEncoder();
		return password;
	}

}
