package com.unla.proyectosoftware.controller;

import javax.servlet.http.HttpSession;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.PerfilModel;
import com.unla.proyectosoftware.models.UsuarioModel;
import com.unla.proyectosoftware.services.IPerfilService;
import com.unla.proyectosoftware.services.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	@Qualifier("usuarioService")
	public IUsuarioService usuarioService;
	
	@Autowired
	@Qualifier("perfilService")
	public IPerfilService perfilService;

	@GetMapping("")
	public String toLogin(){
		return ViewRouteHelper.LOGIN;
	}

	@GetMapping("/registro")
	public ModelAndView registrar() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.REGISTRO);
		mV.addObject("usuario", new UsuarioModel());
		return mV;
	}
	
	@PostMapping("/guardar")
	public RedirectView guardarUsuario(@ModelAttribute("usuario") UsuarioModel usuario) {
		PerfilModel perfil = perfilService.traerPorNombre("ROLE_ESTUDIANTE");
		usuario.setPerfil(perfil);
		usuarioService.insertOrUpdate(usuario);
		return new RedirectView("/login");
	}
	 
	@GetMapping("/success")
	public RedirectView index(Authentication auth, HttpSession session, Model model) {
		RedirectView redirect = new RedirectView();
		String username= auth.getName();

		UsuarioModel user = usuarioService.traerUsuarioYPerfil(username);
		System.out.println(user.toString());
		
		if(user.getPerfil().getNombreRol().equals("ROLE_ADMIN")){
			redirect.setUrl("/admin");
		} if (user.getPerfil().getNombreRol().equals("ROLE_PROFESOR")) {
			redirect.setUrl("/profesor/"+user.getIdUsuario());
		} if (user.getPerfil().getNombreRol().equals("ROLE_ESTUDIANTE")) {
			redirect.setUrl("/");
		}
		
		return redirect;
	}
}