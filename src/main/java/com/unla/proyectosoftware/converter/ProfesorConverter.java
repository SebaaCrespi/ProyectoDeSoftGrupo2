package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.Profesor;
import com.unla.proyectosoftware.models.ProfesorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("profesorConverter")
public class ProfesorConverter {
    
    @Autowired
    @Qualifier("perfilConverter")
    private PerfilConverter perfilConverter;

    public Profesor modelToEntity(ProfesorModel profesorModel){
        return new Profesor(profesorModel.getIdUsuario(),
                            profesorModel.getMail(),
                            profesorModel.getUsername(),
                            profesorModel.getPassword(),
                            perfilConverter.modeltoEntity(profesorModel.getPerfil()),
                            profesorModel.getNombre(),
                            profesorModel.getApellido());
    }

    public ProfesorModel entityToModel(Profesor profesor){
        return new ProfesorModel(profesor.getIdUsuario(),
                                 profesor.getMail(),
                                 profesor.getUsername(),
                                 profesor.getPassword(),
                                 perfilConverter.entityToModel(profesor.getPerfil()),
                                 profesor.getNombre(),
                                 profesor.getApellido());
    }
}
