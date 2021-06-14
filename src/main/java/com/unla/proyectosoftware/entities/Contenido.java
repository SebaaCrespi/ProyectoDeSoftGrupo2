package com.unla.proyectosoftware.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contenido")
public class Contenido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContenido;

	@Column(name = "titulo")
	private String titulo;
	
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "archivo")
    private boolean archivo;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name="idMateria")
   	private Materia materia;
    
    public Contenido() {}

	public Contenido(int idContenido,String titulo ,String nombre,boolean archivo, Materia materia) {
		super();
		this.idContenido = idContenido;
		this.titulo = titulo;
		this.nombre = nombre;
        this.archivo = archivo;
		this.materia = materia;
	}

	public int getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(int idContenido) {
		this.idContenido = idContenido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
    
}