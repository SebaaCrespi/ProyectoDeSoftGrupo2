package com.unla.proyectosoftware.models;

import java.util.Set;

public class MateriaModel {

    private int idMateria;
    private String nombre;
    private CarreraModel carrera;
    private Set<ProfesorModel> profesores;

    public MateriaModel() {}
    
    public MateriaModel(int idMateria, String nombre, CarreraModel carrera) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public MateriaModel(int idMateria, String nombre, CarreraModel carrera, Set<ProfesorModel> profesores) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.carrera = carrera;
        this.profesores = profesores;
    }

    public int getIdMateria() {
        return idMateria;
    }

    protected void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CarreraModel getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraModel carrera) {
        this.carrera = carrera;
    }

    public Set<ProfesorModel> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<ProfesorModel> profesores) {
        this.profesores = profesores;
    }
    
}
