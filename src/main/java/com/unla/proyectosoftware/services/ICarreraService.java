package com.unla.proyectosoftware.services;

import com.unla.proyectosoftware.models.CarreraModel;

import java.util.List;

public interface ICarreraService {

	public List<CarreraModel> findAll();
	
	public List<CarreraModel> findAllWithIdUniversidad(int idUniversidad);
	
	public CarreraModel findByIdCarrera(int id);
	
	public void insertOrUpdate(CarreraModel model);
}