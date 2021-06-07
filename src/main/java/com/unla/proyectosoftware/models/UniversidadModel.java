package com.unla.proyectosoftware.models;

import java.util.Set;

public class UniversidadModel {

    private int idUniversidad;
    private String nombre;
    private String logo;
    private Set<CarreraModel> carreras;
    private AdministradorUnivModel administradorUnivModel;

    public UniversidadModel(){}

    public UniversidadModel(int idUniversidad, String nombre, String logo){
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
    }

    public UniversidadModel(int idUniversidad, String nombre, String logo, AdministradorUnivModel administradorUnivModel){
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
        this.administradorUnivModel = administradorUnivModel;
    }
    
    public UniversidadModel(int idUniversidad, String nombre,String logo, AdministradorUnivModel administradorUnivModel, Set<CarreraModel> carreras) {
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.logo = logo;
        this.administradorUnivModel = administradorUnivModel;
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
    
    public AdministradorUnivModel getAdministradorUnivModel() {
        return administradorUnivModel;
    }

    public void setAdministradorUnivModel(AdministradorUnivModel administradorUnivModel) {
        this.administradorUnivModel = administradorUnivModel;
    }

    public Set<CarreraModel> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<CarreraModel> carreras) {
        this.carreras = carreras;
    }
 

}
