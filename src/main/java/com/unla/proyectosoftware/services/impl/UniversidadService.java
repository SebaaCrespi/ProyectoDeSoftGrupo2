package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.unla.proyectosoftware.converter.UniversidadConverter;
import com.unla.proyectosoftware.entities.Universidad;
import com.unla.proyectosoftware.models.UniversidadModel;
import com.unla.proyectosoftware.repository.IUniversidadRespository;
import com.unla.proyectosoftware.services.IUniversidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("universidadService")
public class UniversidadService implements IUniversidadService{

    @Autowired
    @Qualifier("universidadRepository")
    public IUniversidadRespository universidadRepository;

    @Autowired
    @Qualifier("universidadConverter")
    public UniversidadConverter universidadConverter;

    public List<UniversidadModel> traerUniversidades(){
        List<UniversidadModel> universidades= new ArrayList<>();
        for(Universidad u : universidadRepository.findAll()){
            universidades.add(universidadConverter.entityToModel(u));
        }
        return universidades;
    }

    public void insertOrUpdate(UniversidadModel univ){
        universidadRepository.save(universidadConverter.modelToEntity(univ));
    }

    @Override
	public UniversidadModel findByIdUniversidad(int id) {
		UniversidadModel aux = universidadConverter.entityToModel(universidadRepository.getById(id));
		return aux;
	}
}
