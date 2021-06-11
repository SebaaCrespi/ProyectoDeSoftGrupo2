package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.unla.proyectosoftware.converter.ContenidoConverter;
import com.unla.proyectosoftware.entities.Contenido;
import com.unla.proyectosoftware.models.ContenidoModel;
import com.unla.proyectosoftware.repository.IContenidoRepository;
import com.unla.proyectosoftware.services.IContenidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contenidoService")
public class ContenidoService implements IContenidoService {
    
    @Autowired
    @Qualifier("contenidoRepository")
    public IContenidoRepository contenidoRepository;

    @Autowired
    @Qualifier("contenidoConverter")
    public ContenidoConverter contenidoConverter;

    public void insertOrUpdate(ContenidoModel model){
        contenidoRepository.save(contenidoConverter.modelToEntity(model));
    }

    public List<ContenidoModel> getAll(){
        List<ContenidoModel> contenidos = new ArrayList<>();
        for(Contenido c : contenidoRepository.findAll()){
            contenidos.add(contenidoConverter.entityToModel(c));
        }
        return contenidos;
    }

    public Set<ContenidoModel> traerPorIdMateria(int idMateria){
        Set<ContenidoModel> contenidos = new HashSet<>();
        for(Contenido c : contenidoRepository.findByIdMateria(idMateria)){
            contenidos.add(contenidoConverter.entityToModel(c));
        }
        return contenidos;
    }

    public void remove(int idContenido){
        contenidoRepository.delete(contenidoRepository.findByIdContenido(idContenido));
    }
}

