package com.unla.proyectosoftware.models;


public class AdministradorUnivModel extends UsuarioModel {
    
    private UniversidadModel universidadModel;

    public AdministradorUnivModel() {}

    public AdministradorUnivModel(int idUsuario, String username, String password, String email, PerfilModel perfil) {
        super(idUsuario, username, password, email, perfil);
    }

    public UniversidadModel getUniversidadModel() {
        return universidadModel;
    }

    public void setUniversidadModel(UniversidadModel universidadModel) {
        this.universidadModel = universidadModel;
    }
    
}
