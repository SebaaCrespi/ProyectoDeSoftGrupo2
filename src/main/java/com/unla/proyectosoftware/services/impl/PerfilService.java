package com.unla.proyectosoftware.services.impl;

import com.unla.proyectosoftware.converter.PerfilConverter;
import com.unla.proyectosoftware.models.PerfilModel;
import com.unla.proyectosoftware.repository.IPerfilRepository;
import com.unla.proyectosoftware.services.IPerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("perfilService")
public class PerfilService implements IPerfilService{

    @Autowired
    @Qualifier("perfilRepository")
    public IPerfilRepository perfilRepository;

    @Autowired
    @Qualifier("perfilConverter")
    public PerfilConverter perfilConverter;

    public PerfilModel traerPorNombre(String nombreRol){
        return perfilConverter.entityToModel(perfilRepository.findByNombreRol(nombreRol));
    }
}
