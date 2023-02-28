package com.carlos.gestion.configuracion;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
	}
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/clientes").hasAnyRole("ADMINISTRATIVO", "GESTOR")
		.antMatchers("/login").permitAll().and().cors().and()
		.formLogin()
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/user/logincheck")
		.failureUrl("/user/loginfail")
		.failureForwardUrl("/user/loginfail")
			.and()
		.logout()
			.logoutUrl("/haz_logout")
			.deleteCookies("JSESSIONID")
			.and()
	        .csrf().disable()

		;		

	}




	

}
