package com.unla.proyectosoftware.services;

import java.util.List;

import com.unla.proyectosoftware.models.MateriaModel;

public interface IMateriaService {
    
    public List<MateriaModel> traerMaterias();

    public MateriaModel traerPorId(int id);

    public List<MateriaModel> findAllWithIdCarrera(int idCarrera);

    public MateriaModel insertOrUpdate(MateriaModel materia);
}
