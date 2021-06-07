package com.unla.proyectosoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.services.ICarreraService;
import com.unla.proyectosoftware.services.IMateriaService;
import com.unla.proyectosoftware.services.IUniversidadService;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

	@Autowired
	@Qualifier("universidadService")
	public IUniversidadService universidadService;
	
	@Autowired
	@Qualifier("carreraService")
	public ICarreraService carreraService;
	
	@Autowired
	@Qualifier("materiaService")
	public IMateriaService materiaService;
	
	@GetMapping("")
	public ModelAndView panel() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ESTUDIANTE_PANEL);
		mV.addObject("universidades",universidadService.traerUniversidades());
		return mV;
	}
	
	@GetMapping("/carrera/{id}")
	public ModelAndView mostrarCarrera(@PathVariable ("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ESTUDIANTE_CARRERA);
		mV.addObject("carreras",carreraService.findAllWithIdUniversidad(id));
		return mV;
	}
	
	@GetMapping("/materia/{id}")
	public ModelAndView mostrarMateria(@PathVariable ("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ESTUDIANTE_MATERIA);
		System.out.println("este id se guarda" + id);
		mV.addObject("idCarrera",id);
		mV.addObject("materias", materiaService.findAllWithIdCarrera(id));
		return mV;
	}
}
