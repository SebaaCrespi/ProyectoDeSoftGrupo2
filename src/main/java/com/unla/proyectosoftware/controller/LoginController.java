package com.unla.proyectosoftware.controller;

import javax.servlet.http.HttpSession;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.UsuarioModel;
import com.unla.proyectosoftware.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;




@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	@GetMapping("")
	public String toLogin(){
		return ViewRouteHelper.LOGIN;
	}

	@GetMapping("/success")
	public RedirectView index(Authentication auth, HttpSession session, Model model) {
		RedirectView redirect = new RedirectView();
		String username= auth.getName();

		UsuarioModel user = usuarioService.traerUsuarioYPerfil(username);

		if(user.getPerfil().getNombreRol().equals("ROLE_ADMIN")){
			redirect.setUrl("/admin");
		}
		return redirect;
	}

}