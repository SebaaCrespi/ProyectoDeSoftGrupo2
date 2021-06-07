package com.unla.proyectosoftware.repository;

import java.io.Serializable;
import java.util.List;

import com.unla.proyectosoftware.entities.Universidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("universidadRepository")
public interface IUniversidadRespository extends JpaRepository<Universidad, Serializable> {
      
    public List<Universidad> findAll();
}
