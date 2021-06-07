package com.unla.proyectosoftware.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.unla.proyectosoftware.entities.Profesor;
import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.CarreraModel;
import com.unla.proyectosoftware.models.MateriaModel;
import com.unla.proyectosoftware.models.ProfesorModel;
import com.unla.proyectosoftware.models.UniversidadModel;
import com.unla.proyectosoftware.services.ICarreraService;
import com.unla.proyectosoftware.services.IMateriaService;
import com.unla.proyectosoftware.services.IPerfilService;
import com.unla.proyectosoftware.services.IProfesorService;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("perfilService")
    public IPerfilService perfilService;
	
	@Autowired
    @Qualifier("universidadService")
    public IUniversidadService universidadService; 

	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService;
    
    @Autowired
    @Qualifier("materiaService")
    public IMateriaService materiaService;

	@Autowired
    @Qualifier("profesorService")
    public IProfesorService profesorService;
	
	

    // -----------------------------------------------------------
    //                           UNIVERSIDAD
    // -----------------------------------------------------------
 
    @GetMapping("")
    public ModelAndView panel(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_PANEL);
        mV.addObject("universidades", universidadService.traerUniversidades());
        return mV;
    }

    @GetMapping("/alta/universidad")
    public ModelAndView alta(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_UNIV);
        mV.addObject("universidad", new UniversidadModel());
        return mV;
    }

    @GetMapping("/modificar/universidad/{id}")
    public ModelAndView modificar(@PathVariable ("id") int id){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MODIFICAR_UNIV);
        mV.addObject("universidad", new UniversidadModel());
        return mV;
    }

    @PostMapping("/guardar/universidad")
    public RedirectView guardarUniversidad(@ModelAttribute("universidad") UniversidadModel univ, @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            String routeImg = "C://Universidades";
            try{
                byte[] bytesImg = file.getBytes();
                Path direcCompleta = Paths.get(routeImg + "//" + file.getOriginalFilename());
                Files.write(direcCompleta,bytesImg);
                univ.setLogo(file.getOriginalFilename());
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
        universidadService.insertOrUpdate(univ);
        return new RedirectView(ViewRouteHelper.ADMIN_ROOT);
    }

	@GetMapping("/universidad/{id}")
	public ModelAndView mostrarUniversidad(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MOSTRAR_UNIV);
		mV.addObject("universidad", universidadService.findByIdUniversidad(id));
		mV.addObject("carreras", carreraService.findAllWithIdUniversidad(id));
		return mV;
	}

	// -----------------------------------------------------------
    //                           CARRERA
    // -----------------------------------------------------------

	@GetMapping("/alta/carrera/{idUniversidad}")
	public ModelAndView index(@PathVariable("idUniversidad") int idUniversidad) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_CARRERA);
		mV.addObject("idUniversidad",idUniversidad);
		mV.addObject("carrera",new CarreraModel());
		return mV;
	}
	
	@PostMapping("/guardar/carrera/{idUniversidad}")
	public RedirectView guardarCarrera(@ModelAttribute("carrera") CarreraModel carrera,
									   @PathVariable("idUniversidad") int idUniversidad) {	
		CarreraModel aux = carrera;
		aux.setUniversidad(universidadService.findByIdUniversidad(idUniversidad));
		System.out.println(aux);
		carreraService.insertOrUpdate(carrera);
		return new RedirectView("/admin/universidad/"+idUniversidad);
	}

    @GetMapping("/carrera/{id}")
	public ModelAndView mostrarCarrera(@PathVariable("id") int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MOSTRAR_CARRERA);
		mV.addObject("carrera", carreraService.findByIdCarrera(id));
		mV.addObject("materias",materiaService.findAllWithIdCarrera(id));
		return mV;
	}

    // -----------------------------------------------------------
    //                           MATERIA
    // -----------------------------------------------------------

    @GetMapping("/alta/materia/{idCarrera}")
    public ModelAndView altaMateria(@PathVariable ("idCarrera") int idCarrera){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_MATERIA);
        mV.addObject("idCarrera", idCarrera);
        mV.addObject("materia", new MateriaModel());
        return mV;
    }

    @PostMapping("/guardar/materia/{idCarrera}")
    public RedirectView guardarMateria(@ModelAttribute("materia") MateriaModel materia,@PathVariable ("idCarrera") int idCarrera){
        materia.setCarrera(carreraService.findByIdCarrera(idCarrera));
        materiaService.insertOrUpdate(materia);
        return new RedirectView("/admin/carrera/"+idCarrera);
    }

    @GetMapping("/materia/{idMateria}")
    public ModelAndView mostrarMateria(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MOSTRAR_MATERIA);
        mV.addObject("profesores", profesorService.traerProfesoresPorIdMateria(idMateria));
        mV.addObject("materia", materiaService.traerPorId(idMateria));
        return mV;
    }

    @GetMapping("/materia/agregarProfesor/{idMateria}")
    public ModelAndView listarProfesores(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_MATERIA_AGREGAR_PROFESOR);
        mV.addObject("profesoresList", profesorService.traerProfesores());
        mV.addObject("materia", materiaService.traerPorId(idMateria));
        return mV;
    }
    
    @PostMapping("/materia/agregarProfesor/{idMateria}")
    public RedirectView agregarProfesor(@PathVariable ("idMateria") int idMateria, @RequestParam (required =  true) int profesor){
        MateriaModel materia = materiaService.traerPorId(idMateria);
        ProfesorModel profesorModel = profesorService.traerPorId(profesor);
        materia.getProfesores().add(profesorModel);
        materiaService.insertOrUpdate(materia);
        return new RedirectView("/admin/materia/"+idMateria);
    }
    // -----------------------------------------------------------
    //                           PROFESOR
    // -----------------------------------------------------------
    @GetMapping("/alta/profesor/{idMateria}")
    public ModelAndView altaProfesorDesdeMateria(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_PROFESOR);
        mV.addObject("profesor", new ProfesorModel());
        mV.addObject("perfil", perfilService.traerPorNombre("ROLE_PROFESOR"));
        System.out.println("ID MATERIA "+idMateria);
        mV.addObject("idMateria", idMateria);
        return mV;
    }

    @GetMapping("/alta/profesor")
    public ModelAndView altaProfesor(){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.ADMIN_ALTA_PROFESOR);
        mV.addObject("profesor", new ProfesorModel());
        mV.addObject("perfil", perfilService.traerPorNombre("ROLE_PROFESOR"));
        return mV;
    }

    @PostMapping("/guardar/profesor")
    public RedirectView guardarProfesor(@ModelAttribute("profesor") ProfesorModel profesor,
                                        @RequestParam (required = true) int idMateria){
        profesorService.insertOrUpdate(profesor);
        return new RedirectView("/admin/materia/agregarProfesor/"+idMateria);
    }
    
}
