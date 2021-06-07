package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.List;

import com.unla.proyectosoftware.entities.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("materiaRepository")
public interface IMateriaRepository extends JpaRepository<Materia, Serializable>{

    @Query("select m from Materia m inner join fetch m.carrera mc WHERE mc.idCarrera  = (:idCarrera)")
	public List<Materia> findByIdCarrera(@Param ("idCarrera") int idCarrera);

    public List<Materia> findAll();   
    
    public Materia findByIdMateria(int idMateria);
}
    

