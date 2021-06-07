package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.proyectosoftware.entities.Carrera;

@Repository("carreraRepository")
public interface ICarreraRepository extends JpaRepository<Carrera, Serializable>{

	@Query("select c from Carrera c inner join fetch c.universidad cu WHERE cu.idUniversidad  = (:idUniversidad)")
	public List<Carrera> findByIdUniversidad(@Param ("idUniversidad") int idUniversidad);

	public Carrera findByIdCarrera(int id);
}