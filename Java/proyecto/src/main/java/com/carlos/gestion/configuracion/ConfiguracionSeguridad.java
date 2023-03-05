package com.carlos.gestion.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.carlos.gestion.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jdbcUserDetailsManager()).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/v1/**").hasAnyRole("ADMINISTRATIVO", "GESTOR")
		.antMatchers("/v2/**").hasRole("GESTOR")
		.antMatchers("/registro").permitAll()
		.antMatchers("/autenticacion").permitAll().anyRequest().authenticated().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors().and().csrf().disable();
	}
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);

		return jdbcUserDetailsManager;
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
