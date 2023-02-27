package com.carlos.gestion.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
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
			.antMatchers("/alumnos/listadoalumnos").hasAnyRole("ADMINISTRATIVO", "GESTOR")
			.antMatchers("/alumnos/formularioactualizaralumnos").hasRole("GESTOR")
			.antMatchers("/v1/alumnos").hasRole("GESTOR")
			.and()
		.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.and()
		.logout()
			.logoutUrl("/haz_logout")
			.logoutSuccessUrl("/login")
			.deleteCookies("JSESSIONID")
		;
		http.csrf().disable();

	}
	

}