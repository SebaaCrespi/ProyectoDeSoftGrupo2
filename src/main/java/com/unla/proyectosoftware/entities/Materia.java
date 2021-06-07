package com.unla.proyectosoftware.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    @JoinTable(
        name = "profesorxmateria",
        joinColumns = @JoinColumn(name = "materiaId", nullable = false),
        inverseJoinColumns = @JoinColumn(name="profesorId", nullable = false)
    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Profesor> profesores;

    public Materia() {}

    public Materia(int idMateria, String nombre, Carrera carrera) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public Materia(int idMateria, String nombre, Carrera carrera, Set<Profesor> profesores) {
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    
    
}
