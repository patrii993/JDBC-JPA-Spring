package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicioImpl.ServicioRol;
import com.dawes.servicioImpl.ServicioUsuario;
import com.dawes.servicioImpl.ServicioUsuarioRol;

@Controller
@RequestMapping("/")
public class PrincipalController {
	
	 @Autowired
	 ServicioRol sr;
	 @Autowired
	 ServicioUsuario su;
	 @Autowired
	 ServicioUsuarioRol sur;
	
	//principal
	@RequestMapping("/principal")
	public String principal() {
		return "principal";
	}
	//Admin
	@RequestMapping("/admin")
	public String admin() {
		return"admin/admin";
	}
	//User
	@RequestMapping("/user")
	public String user() {
		return "user/regis";
	}
	//login
	@RequestMapping("/login")
	public String login() {
		return "/loginer/login";
	}
	//logout
	@RequestMapping("/logout")
	public String logout() {
		return "/loginer/logout";
	}
	@RequestMapping("/403")
	public String p403() {
		return "error/403";
	}
	@RequestMapping("/formregistro")
	public String formregistro(Model modelo) {
		modelo.addAttribute("usuario", new UsuarioVO());
	return "/loginer/formregistro";	
		
	}
	@RequestMapping("/registro")
	public String registro(@ModelAttribute UsuarioVO usuario, Model modelo) {
		su.registro(usuario);
		sur.save(new UsuarioRolVO(0, usuario, sr.findById(1).get()));
		return "/loginer/login";
	}
	

}
