package com.unla.proyectosoftware.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "administradorUniv")
@PrimaryKeyJoinColumn(name="usuarioId")
public class AdministradorUniv extends Usuario {
    
    @OneToOne(mappedBy = "administradorUniv")
    private Universidad universidad;

    public AdministradorUniv() {}

    public AdministradorUniv(int idUsuario, String mail, String username, String password, Perfil perfil) {
        super(idUsuario, mail, username, password, perfil);
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
}
