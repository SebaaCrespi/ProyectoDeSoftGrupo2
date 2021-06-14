package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.Set;

import com.unla.proyectosoftware.entities.Contenido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("contenidoRepository")
public interface IContenidoRepository extends JpaRepository<Contenido, Serializable> {
    
    @Query("SELECT c FROM Contenido c JOIN FETCH c.materia m WHERE m.idMateria = (:idMateria)")
    public abstract Set<Contenido> findByIdMateria(@Param ("idMateria") int idMateria);

    public Contenido findByIdContenido(int idContenido);
}
