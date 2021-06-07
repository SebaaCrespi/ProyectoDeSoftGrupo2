package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.unla.proyectosoftware.converter.MateriaConverter;
import com.unla.proyectosoftware.entities.Materia;
import com.unla.proyectosoftware.models.MateriaModel;
import com.unla.proyectosoftware.repository.IMateriaRepository;
import com.unla.proyectosoftware.services.IMateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("materiaService")
public class MateriaService implements IMateriaService{
    
    @Autowired
    @Qualifier("materiaRepository")
    public IMateriaRepository materiaRepository;

    @Autowired
    @Qualifier("materiaConverter")
    public MateriaConverter materiaConverter;

    public List<MateriaModel> traerMaterias(){
        List<MateriaModel> materias = new ArrayList<>();
        for(Materia m : materiaRepository.findAll()){
            materias.add(materiaConverter.entityToModel(m));
        }
        return materias;
    }

    public MateriaModel traerPorId(int id){
        return materiaConverter.entityToModel(materiaRepository.findByIdMateria(id));
    }

    public MateriaModel insertOrUpdate(MateriaModel materiaModel){
        return materiaConverter.entityToModel(materiaRepository.save(materiaConverter.modelToEntity(materiaModel)));
    }

    public List<MateriaModel> findAllWithIdCarrera(int idCarrera){
        List<MateriaModel> aux = new ArrayList<>();
		for (Materia c : materiaRepository.findByIdCarrera(idCarrera)) {
			aux.add(materiaConverter.entityToModel(c));
		}
		return aux;
    }
}
