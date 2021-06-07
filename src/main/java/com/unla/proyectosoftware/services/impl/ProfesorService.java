package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.unla.proyectosoftware.converter.ProfesorConverter;
import com.unla.proyectosoftware.entities.Profesor;
import com.unla.proyectosoftware.models.ProfesorModel;
import com.unla.proyectosoftware.repository.IProfesorRepository;
import com.unla.proyectosoftware.services.IProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("profesorService")
public class ProfesorService implements IProfesorService{
    
    @Autowired
    @Qualifier("profesorConverter")
    public ProfesorConverter profesorConverter;

    @Autowired
    @Qualifier("profesorRepository")
    public IProfesorRepository profesorRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<ProfesorModel> traerProfesores(){
        List<ProfesorModel> profesores = new ArrayList<>();
        for(Profesor p : profesorRepository.findAll()){
            profesores.add(profesorConverter.entityToModel(p));
        }
        return profesores;
    }

    public List<ProfesorModel> traerProfesoresPorIdMateria(int idMateria){
        List<ProfesorModel> profesores = new ArrayList<>();
        for(Profesor p : profesorRepository.findByIdMateria(idMateria)){
            profesores.add(profesorConverter.entityToModel(p));
        }
        return profesores;
    }

    public ProfesorModel insertOrUpdate(ProfesorModel profesorModel){
        profesorModel.setPassword(bCryptPasswordEncoder.encode(profesorModel.getPassword()));
        return profesorConverter.entityToModel(profesorRepository.save(profesorConverter.modelToEntity(profesorModel)));
    }

    public ProfesorModel traerPorId(int idUsuario){
        return profesorConverter.entityToModel(profesorRepository.findByIdUsuario(idUsuario));
    }
}
