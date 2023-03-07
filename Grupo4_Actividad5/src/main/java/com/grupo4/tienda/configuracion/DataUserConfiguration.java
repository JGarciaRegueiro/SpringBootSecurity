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
			.usersByUsernameQuery("select username, pass, 'true' as enabled from Usuarios where username=?")
			.authoritiesByUsernameQuery("select u.username, r.nombre_rol from usuarios u join usuariosroles ur on u.id_usuario = ur.id_usuario join roles r on ur.id_rol = r.id_rol where u.username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			//permitimos sin auth
			.antMatchers("/bootstrap/**", "/images/**", "/css/**", "js/**", "/rest/**").permitAll()
			//vistas sin auth
			.antMatchers("/**", "/login", "/logout", "/registro", "/search").permitAll()
			//vistas para roles
			.antMatchers("/categorias/**", "/perfil/**").hasAnyAuthority("ROLE_CLIENTE")
			.antMatchers("/producto/**","/usuario/**","/categorias/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			
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
