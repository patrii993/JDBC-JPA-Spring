package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.servicioImpl.ServicioUsuarioImp;

@Configuration
@EnableWebSecurity
public class MiSeguridad {
	@Autowired
	ServicioUsuarioImp su;
	
	@Bean
	public BCryptPasswordEncoder encripta() {
		return new BCryptPasswordEncoder();
	}


	// Los filtros se disparan automaticamente que siempre van anotados con bean:
	// componente en memoria que maneja spring
	@Bean
	public SecurityFilterChain filtrocompleto(HttpSecurity http) throws Exception {
		
		  http 
		  .getSharedObject(AuthenticationManagerBuilder.class)
		  .userDetailsService(su)
		  .passwordEncoder(encripta());
		 
		
		// autorizaciones dentro del filtro
		// Autorizamos accesos a los recursos de user
		http
		.authorizeHttpRequests().requestMatchers("/user/**").hasAnyRole("ADMIN", "USER").and().exceptionHandling()
				.accessDeniedPage("/403");
		// Autorizamos acceso a los recursos del admin
		http.authorizeHttpRequests().requestMatchers("/admin/**").hasAnyRole("ADMIN").and().exceptionHandling()
				.accessDeniedPage("/403");

		// Acceso publico a los recursos que están en el raiz ("/")
				http.authorizeHttpRequests().requestMatchers("/","/principal","/logout", "/login", "/formregistro", "/registro","/css/**","/img/**").permitAll().anyRequest()
						.authenticated();

		// Utilizamos un formulario de login personalizado
		http.formLogin().loginPage("/login").permitAll();
		http.logout().logoutUrl("/logout").permitAll();
		return http.build();
	}

}
