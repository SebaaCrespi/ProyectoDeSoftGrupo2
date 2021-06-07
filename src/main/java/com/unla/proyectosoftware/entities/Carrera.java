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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idUniversidad")
	private Universidad universidad;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "carrera")
    private Set<Materia> materias;

    public Carrera() {}

    public Carrera(int idCarrera, String nombre, Universidad universidad) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.universidad = universidad;
    }

    public Carrera(int idCarrera, String nombre, Universidad universidad, Set<Materia> materias) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.universidad = universidad;
        this.materias = materias;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    protected void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }
    
    
}
