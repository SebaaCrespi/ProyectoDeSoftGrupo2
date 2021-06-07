package com.unla.proyectosoftware.models;

public class UsuarioModel {
	
	private int idUsuario;
	private String username;
	private String password;
	private String mail;
	private PerfilModel perfil;
	
	public UsuarioModel() {}

	public UsuarioModel(int idUsuario, String username, String password, String mail,
			PerfilModel perfil) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}
	
}


