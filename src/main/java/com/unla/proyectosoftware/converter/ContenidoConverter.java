package com.unla.proyectosoftware.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.proyectosoftware.entities.Contenido;
import com.unla.proyectosoftware.models.ContenidoModel;

@Component("contenidoConverter")
public class ContenidoConverter {

	@Autowired
	@Qualifier("materiaConverter")
	public MateriaConverter materiaConverter;
	
	public Contenido modelToEntity(ContenidoModel contenidoModel) {
		return new Contenido(contenidoModel.getIdContenido(),
							 contenidoModel.getTitulo(),
							 contenidoModel.getNombre(),
                             contenidoModel.isArchivo(),
							 materiaConverter.modelToEntity(contenidoModel.getMateriaModel()));
	}
	
	public ContenidoModel entityToModel(Contenido contenido) {
		return new ContenidoModel(contenido.getIdContenido(),
								  contenido.getTitulo(),
								  contenido.getNombre(),
                                  contenido.isArchivo(),
								  materiaConverter.entityToModel(contenido.getMateria()));
	}
}