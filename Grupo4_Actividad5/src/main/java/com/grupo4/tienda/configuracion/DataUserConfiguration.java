package com.grupo4.tienda.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class DataUserConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email,pass from Usuarios where email=?")
			.authoritiesByUsernameQuery("select u.id_usuario, r.id_rol from Usuarios_Roles ur " +
			"inner join Usuarios u on u.id_usuario= ur.id_usuario " +
			"inner join Roles r on r.id_rol = ur.id_rol " + "where u.id_usuario=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			//permitimos sin auth
			.antMatchers("/bootstrap/**", "/images/**", "/css/**", "js/**").permitAll()
			//vistas sin auth
			.antMatchers("/inicio", "/login","/logout", "/registro", "/search").permitAll()
			//vistas para roles
			.antMatchers("/categorias/**").hasAnyAuthority("ROLE_CLIENTE")
			
			//Todas las demás requieren auth
			.anyRequest().authenticated()
			//el formulario de login no requiere autenticación
			.and().formLogin().permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
