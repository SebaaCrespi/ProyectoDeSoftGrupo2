package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.Carrera;
import com.unla.proyectosoftware.models.CarreraModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carreraConverter")
public class CarreraConverter {
    
    @Autowired
    @Qualifier("universidadConverter")
    public UniversidadConverter universidadConverter;

    public Carrera modelToEntity(CarreraModel carreraModel){
        return new Carrera(carreraModel.getIdCarrera(),
                           carreraModel.getNombre(),
                           universidadConverter.modelToEntity(carreraModel.getUniversidad()));
    } 

    public CarreraModel entityToModel(Carrera carrera){
        return new CarreraModel(carrera.getIdCarrera(),
                                carrera.getNombre(),
                                universidadConverter.entityToModel(carrera.getUniversidad()));
    }
}
