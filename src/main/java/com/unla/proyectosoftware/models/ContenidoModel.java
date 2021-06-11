package com.unla.proyectosoftware.models;

public class ContenidoModel {
	
	private int idContenido;
	private String titulo;
	private String nombre;
    private boolean archivo;
	private MateriaModel materiaModel;
	
	public ContenidoModel() {}

	public ContenidoModel(int idContenido,String titulo, String nombre,boolean archivo, MateriaModel materiaModel) {
		this.idContenido = idContenido;
		this.titulo = titulo;
		this.nombre = nombre;
        this.archivo = archivo;
		this.materiaModel = materiaModel;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public boolean isArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        this.archivo = archivo;
    }

	public MateriaModel getMateriaModel() {
		return materiaModel;
	}

	public void setMateriaModel(MateriaModel materiaModel) {
		this.materiaModel = materiaModel;
	}
	
	
}