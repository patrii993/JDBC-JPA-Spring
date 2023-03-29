package com.dawes.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UsuarioRepositorio;
@Service
public class ServicioUsuarioImp implements UserDetailsService, ServicioUsuario {
	@Autowired
	UsuarioRepositorio ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return ur.findByUsername(username);
	}

	
	@Override
	public void registro(UsuarioVO u) {
		u.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
		ur.save(u);
	}
}
