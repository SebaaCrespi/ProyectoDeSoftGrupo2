package com.unla.proyectosoftware.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	@Column(name = "nombreRol")
	private String nombreRol;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="perfil")  //1 ROL TIENE MUCHOS USUARIOS  . perfil ES DE LA LISTA DE USUARIOS
	private Set<Usuario> usuarios;// =new HashSet<Usuario>();
	
	public Perfil() {}

	public Perfil(int idPerfil,String nombreRol) {
		super();
		this.idPerfil = idPerfil;
		this.nombreRol = nombreRol;
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}

	protected void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}


