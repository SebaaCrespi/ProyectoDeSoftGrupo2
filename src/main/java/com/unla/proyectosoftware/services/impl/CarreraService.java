package com.unla.proyectosoftware.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.proyectosoftware.converter.CarreraConverter;
import com.unla.proyectosoftware.entities.Carrera;
import com.unla.proyectosoftware.models.CarreraModel;
import com.unla.proyectosoftware.repository.ICarreraRepository;
import com.unla.proyectosoftware.services.ICarreraService;

@Service("carreraService")
public class CarreraService implements ICarreraService{

	@Autowired
	@Qualifier("carreraConverter")
	private CarreraConverter carreraConverter;
	
	@Autowired
	@Qualifier("carreraRepository")
	private ICarreraRepository carreraRepository;
	
	@Override
	public List<CarreraModel> findAll() {
		List<CarreraModel> aux = new ArrayList<>();
		for (Carrera c : carreraRepository.findAll()) {
			aux.add(carreraConverter.entityToModel(c));
		}
		return aux;
	}

	@Override
	public List<CarreraModel> findAllWithIdUniversidad(int idUniversidad) {
		List<CarreraModel> aux = new ArrayList<>();
		for (Carrera c : carreraRepository.findByIdUniversidad(idUniversidad)) {
			aux.add(carreraConverter.entityToModel(c));
		}
		return aux;
	}

	@Override
	public void insertOrUpdate(CarreraModel model) {
		carreraRepository.save(carreraConverter.modelToEntity(model));
	}

	@Override
	public CarreraModel findByIdCarrera(int id) {
		CarreraModel aux = carreraConverter.entityToModel(carreraRepository.findByIdCarrera(id));
		return aux;
	}
}