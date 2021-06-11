package com.unla.proyectosoftware.controller;


import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.services.ICarreraService;
import com.unla.proyectosoftware.services.IContenidoService;
import com.unla.proyectosoftware.services.IMateriaService;
import com.unla.proyectosoftware.services.IProfesorService;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@Autowired
	@Qualifier("universidadService")
	public IUniversidadService universidadService; 
	
	@Autowired
	@Qualifier("carreraService")
	public ICarreraService carreraService;
	
	@Autowired
	@Qualifier("materiaService")
	public IMateriaService materiaService;

	@Autowired
    @Qualifier("profesorService")
    public IProfesorService profesorService;

	@Autowired
    @Qualifier("contenidoService")
    public IContenidoService contenidoService;
	

	@GetMapping("")
	public ModelAndView toHome() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME);
        mV.addObject("universidades", universidadService.traerUniversidades());
        return mV;
	}
	/*
	--------------------------------------------------------------
	--------------------------------------------------------------
	--------------------------------------------------------------
	--------------------------------------------------------------
    ----------------------------TERMINAR--------------------------
	--------------------------------------------------------------
	--------------------------------------------------------------
	--------------------------------------------------------------
	--------------------------------------------------------------
  */
	@GetMapping("/universidad/buscar")
	public ModelAndView buscarUniversidad(@RequestParam (required = true) String busqueda) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME);
        mV.addObject("universidad", universidadService.traerUniversidadPorNombre(busqueda));		
		return mV;
	}

	@GetMapping("/universidad/{idUniversidad}")
	public ModelAndView mostrarUniversidad(@PathVariable ("idUniversidad") int idUniversidad) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME_UNIVERSIDAD);
		mV.addObject("universidad", universidadService.findByIdUniversidad(idUniversidad));
		mV.addObject("carreras", carreraService.findAllWithIdUniversidad(idUniversidad));
		return mV;
	}
	
	@GetMapping("/universidad/{idUniversidad}/carrera/{idCarrera}")
	public ModelAndView mostrarCarrera(@PathVariable ("idUniversidad") int idUniversidad,@PathVariable("idCarrera") int idCarrera) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME_CARRERA);
		mV.addObject("carrera",carreraService.findByIdCarrera(idCarrera));
		mV.addObject("idUniversidad", idUniversidad);
		mV.addObject("materias",materiaService.findAllWithIdCarrera(idCarrera));
		return mV;
	}

    @GetMapping("/universidad/{idUniversidad}/carrera/{idCarrera}/materia/{idMateria}")
    public ModelAndView mostrarMateria(@PathVariable ("idUniversidad") int idUniversidad,@PathVariable("idCarrera") int idCarrera,@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.HOME_MATERIA);
        mV.addObject("profesores", profesorService.traerProfesoresPorIdMateria(idMateria));
        mV.addObject("materia", materiaService.traerPorId(idMateria));
		mV.addObject("idUniversidad", idUniversidad);
		mV.addObject("idCarrera", idCarrera);
		mV.addObject("contenidos", contenidoService.traerPorIdMateria(idMateria));
        return mV;
    }

	
	
}	

