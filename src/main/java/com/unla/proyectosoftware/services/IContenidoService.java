package com.unla.proyectosoftware.services;

import java.util.List;
import java.util.Set;

import com.unla.proyectosoftware.models.ContenidoModel;

public interface IContenidoService {

    public void insertOrUpdate(ContenidoModel model);

    public List<ContenidoModel> getAll();

    public Set<ContenidoModel> traerPorIdMateria(int idMateria);

    public void remove(int idContenido);
}
