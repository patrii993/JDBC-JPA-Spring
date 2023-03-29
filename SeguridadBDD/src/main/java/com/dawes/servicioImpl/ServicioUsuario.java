package com.dawes.servicioImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuario {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	void registro(UsuarioVO u);

}