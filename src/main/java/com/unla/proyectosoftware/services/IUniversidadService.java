package com.unla.proyectosoftware.services;

import java.util.List;

import com.unla.proyectosoftware.models.UniversidadModel;


public interface IUniversidadService {
    
    public List<UniversidadModel> traerUniversidades();

    public UniversidadModel findByIdUniversidad(int id);

    public void insertOrUpdate(UniversidadModel univ);
}
