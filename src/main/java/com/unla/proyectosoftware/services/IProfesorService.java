package com.unla.proyectosoftware.services;

import java.util.List;

import com.unla.proyectosoftware.models.ProfesorModel;

public interface IProfesorService {
    
    public List<ProfesorModel> traerProfesores();

    public ProfesorModel insertOrUpdate(ProfesorModel profesorModel);
    
    public ProfesorModel traerPorId(int idUsuario);

    public List<ProfesorModel> traerProfesoresPorIdMateria(int idMateria);
}
