package com.unla.proyectosoftware.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "mail")
	private String mail;

	@Column(name = "username")
	private String username; 

	@Column(name = "password")
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY) //1 USUARIO TIENE UN ROL. IdPerfil ES DE LA pk de rol
	@JoinColumn(name="idPerfil")
	private Perfil perfil;
	
	public Usuario () {}
	
	
	public Usuario(int idUsuario, String mail, String username, String password) {
		this.idUsuario = idUsuario;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(int idUsuario, String mail, String username, String password,Perfil perfil) {
		this.idUsuario = idUsuario;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.perfil  = perfil;
	}

	public Usuario( String username, String password, Perfil perfil) {
		super();
		this.username = username;
		this.password = password;
		this.perfil=perfil;
	}	

	public int getIdUsuario() {
		return idUsuario;
	}
	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	
}
