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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "universidad")
public class Universidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniversidad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "logo")
    private String logo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE ,mappedBy="universidad")  //1 ROL TIENE MUCHOS USUARIOS  . perfil ES DE LA LISTA DE USUARIOS
	private Set<Carrera> carreras;// =new HashSet<Usuario>(

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "administradorUnivId", referencedColumnName = "usuarioId")
    private AdministradorUniv administradorUniv;

    public Universidad() {}

    public Universidad(int idUniversidad, String nombre, String logo) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
    }

    public Universidad(int idUniversidad, String nombre, String logo, AdministradorUniv administradorUniv) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
        this.administradorUniv = administradorUniv;
    }
    public Universidad(int idUniversidad, String nombre, String logo, AdministradorUniv administradorUniv, Set<Carrera> carreras) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
        this.administradorUniv = administradorUniv;
        this.carreras = carreras;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    protected void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public AdministradorUniv getAdministradorUniv() {
        return administradorUniv;
    }

    public void setAdministradorUniv(AdministradorUniv administradorUniv) {
        this.administradorUniv = administradorUniv;
    }

    public Set<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    
}
