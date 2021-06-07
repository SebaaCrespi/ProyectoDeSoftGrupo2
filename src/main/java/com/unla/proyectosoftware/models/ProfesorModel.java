package com.unla.proyectosoftware.models;

import java.util.Set;

public class ProfesorModel extends UsuarioModel{
    private String nombre;
    private String apellido;
    private Set<MateriaModel> materias;

    public ProfesorModel(){}
    
    public ProfesorModel(int idUsuario, String username, String password, String mail, PerfilModel perfil, String nombre, String apellido) {
        super(idUsuario, username, password, mail, perfil);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<MateriaModel> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<MateriaModel> materias) {
        this.materias = materias;
    }
    
}
