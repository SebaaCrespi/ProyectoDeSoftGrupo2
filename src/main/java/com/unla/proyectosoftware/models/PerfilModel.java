package com.unla.proyectosoftware.models;

import java.util.HashSet;
import java.util.Set;

public class PerfilModel {
	
	private int idPerfil;
	private String nombreRol;
	private Set<UsuarioModel> usuarios = new HashSet<>();
		
	public PerfilModel() {}

	public PerfilModel(int idPerfil, String nombreRol) {
		super();
		this.setIdPerfil(idPerfil);
		this.nombreRol = nombreRol;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<UsuarioModel> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}

	
	@Override
	public String toString() {
		return "idPerfil: " + idPerfil + "\nnombreRol: " + nombreRol;
	}

	
}
