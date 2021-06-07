package com.unla.proyectosoftware.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.proyectosoftware.entities.Usuario;
import com.unla.proyectosoftware.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	@Autowired
	@Qualifier("perfilConverter")
	private PerfilConverter perfilConverter;
	
	public UsuarioModel entityToModel(Usuario user) {
		UsuarioModel userModel = null;
		if(user != null){
			userModel = new UsuarioModel(user.getIdUsuario(),
										user.getUsername(),
										user.getPassword(),
										user.getMail(),
										perfilConverter.entityToModel(user.getPerfil())
										);
		}
		return userModel;
	}
	
	
	public Usuario modelToEntity(UsuarioModel userModel) {
		return new Usuario(userModel.getIdUsuario(),
							userModel.getUsername(),
							userModel.getPassword(),
							userModel.getMail(),
							perfilConverter.modeltoEntity(userModel.getPerfil())
							);
	}
}
