package com.unla.proyectosoftware.converter;

import com.unla.proyectosoftware.entities.AdministradorUniv;
import com.unla.proyectosoftware.models.AdministradorUnivModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("administradorUnivConverter")
public class AdministradorUnivConverter {
    
    @Autowired
    @Qualifier("perfilConverter")
    private PerfilConverter perfilConverter;

    public AdministradorUnivModel entityToModel(AdministradorUniv admUniv) {
		return new AdministradorUnivModel(admUniv.getIdUsuario(),
                                          admUniv.getUsername(),
                                          admUniv.getPassword(),
                                          admUniv.getMail(),
                                          perfilConverter.entityToModel(admUniv.getPerfil()));
	}

    public AdministradorUniv modelToEntity(AdministradorUnivModel admUnivModel){
        return new AdministradorUniv(admUnivModel.getIdUsuario(),
                                     admUnivModel.getUsername(),
                                     admUnivModel.getPassword(),
                                     admUnivModel.getMail(),
                                     perfilConverter.modeltoEntity(admUnivModel.getPerfil()));
    }

}
