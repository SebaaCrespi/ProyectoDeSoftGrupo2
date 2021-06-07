package com.unla.proyectosoftware.converter;

import org.springframework.stereotype.Component;

import com.unla.proyectosoftware.entities.Perfil;
import com.unla.proyectosoftware.models.PerfilModel;

@Component("perfilConverter")
public class PerfilConverter {

	public PerfilModel entityToModel(Perfil perfil) {
		return new PerfilModel(perfil.getIdPerfil(), perfil.getNombreRol());
	}

	public Perfil modeltoEntity(PerfilModel perfilModel) {
		return new Perfil(perfilModel.getIdPerfil(), perfilModel.getNombreRol());
	}
}
