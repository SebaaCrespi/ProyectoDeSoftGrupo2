package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.List;

import com.unla.proyectosoftware.entities.Profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("profesorRepository")
public interface IProfesorRepository extends JpaRepository<Profesor,Serializable> {
    
    public List<Profesor> findAll();

    @Query("SELECT p FROM Profesor p JOIN FETCH p.materias m WHERE m.idMateria = (:idMateria)")
    public abstract List<Profesor> findByIdMateria(@Param ("idMateria") int idMateria);

    public Profesor findByIdUsuario(int idUsuario);


}
