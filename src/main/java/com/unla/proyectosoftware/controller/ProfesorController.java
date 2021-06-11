package com.unla.proyectosoftware.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import com.unla.proyectosoftware.helpers.ViewRouteHelper;
import com.unla.proyectosoftware.models.ContenidoModel;
import com.unla.proyectosoftware.services.IContenidoService;
import com.unla.proyectosoftware.services.IMateriaService;
import com.unla.proyectosoftware.services.IProfesorService;

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
@RequestMapping("/profesor")
public class ProfesorController {
    
	@Autowired
    @Qualifier("profesorService")
    public IProfesorService profesorService;

    @Autowired
    @Qualifier("materiaService")
    public IMateriaService materiaService;

    @Autowired
    @Qualifier("contenidoService")
    public IContenidoService contenidoService;

    @GetMapping("/{idUsuario}")
    public ModelAndView panel(@PathVariable ("idUsuario") int idUsuario){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PROFESOR_PANEL);
        mV.addObject("profesor", profesorService.traerPorId(idUsuario));
        mV.addObject("materias", materiaService.traerPorProfesor(idUsuario));
        return mV;
    }

    @GetMapping("/materia/{idMateria}")
    public ModelAndView materia(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PROFESOR_MATERIA);
        mV.addObject("materia", materiaService.traerPorId(idMateria));
        mV.addObject("contenidos", contenidoService.traerPorIdMateria(idMateria));
        return mV;
    }

    @GetMapping("/materia/agregarArchivo/{idMateria}")
    public ModelAndView agregarArchivo(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PROFESOR_AGREGAR_ARCHIVO);
        mV.addObject("contenido", new ContenidoModel());
        mV.addObject("idMateria", idMateria);
        return mV;
    }

    @PostMapping("/materia/agregarArchivo/guardar/{idMateria}")
    public RedirectView guardarArchivo(@ModelAttribute("contenido") ContenidoModel contenido, @RequestParam("file") MultipartFile file,@PathVariable ("idMateria") int idMateria){
        if(!file.isEmpty()){
            String routeImg = "C://Contenido";
            try{
                byte[] bytesImg = file.getBytes();
                Path direcCompleta = Paths.get(routeImg + "//" + file.getOriginalFilename());
                Files.write(direcCompleta,bytesImg);
                contenido.setNombre(file.getOriginalFilename());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        contenido.setMateriaModel(materiaService.traerPorId(idMateria));
        contenido.setArchivo(true);
        contenidoService.insertOrUpdate(contenido);
        return new RedirectView("/profesor/materia/"+idMateria);
    }

    @GetMapping("/materia/agregarVideo/{idMateria}")
    public ModelAndView agregarVideo(@PathVariable ("idMateria") int idMateria){
        ModelAndView mV = new ModelAndView(ViewRouteHelper.PROFESOR_AGREGAR_VIDEO);
        mV.addObject("contenido", new ContenidoModel());
        mV.addObject("idMateria", idMateria);
        return mV;
    }

    @PostMapping("/materia/agregarVideo/guardar/{idMateria}")
    public RedirectView guardarVideo(@ModelAttribute("contenido") ContenidoModel contenido,@PathVariable ("idMateria") int idMateria){
        contenido.setMateriaModel(materiaService.traerPorId(idMateria));
        contenido.setArchivo(false);
        contenidoService.insertOrUpdate(contenido);
        return new RedirectView("/profesor/materia/"+idMateria);
    }

    @GetMapping("/materia/eliminarContenido/{idMateria}/{idContenido}")
    public RedirectView eliminarContenido(@PathVariable ("idContenido") int idContenido,@PathVariable ("idMateria") int idMateria){
        contenidoService.remove(idContenido);
        return new RedirectView("/profesor/materia/"+idMateria);
    }

}
