package com.unla.proyectosoftware.controller;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@Autowired
	@Qualifier("universidadService")
	public IUniversidadService universidadService; 

	@GetMapping("")
	public ModelAndView toHome() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME);
        mV.addObject("universidades", universidadService.traerUniversidades());
        return mV;
	}
}
