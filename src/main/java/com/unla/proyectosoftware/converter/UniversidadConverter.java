package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.Universidad;
import com.unla.proyectosoftware.models.UniversidadModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("universidadConverter")
public class UniversidadConverter {

    @Autowired
    @Qualifier("administradorUnivConverter")
    private AdministradorUnivConverter administradorUnivConverter;

    public Universidad modelToEntity(UniversidadModel universidadModel){
        
        return new Universidad(universidadModel.getIdUniversidad(),
                               universidadModel.getNombre(),
                               universidadModel.getLogo()
                               );

    }

    public UniversidadModel entityToModel(Universidad universidad){
        
        return new UniversidadModel(universidad.getIdUniversidad(),
                                    universidad.getNombre(),
                                    universidad.getLogo()
                                   );
    }
}
