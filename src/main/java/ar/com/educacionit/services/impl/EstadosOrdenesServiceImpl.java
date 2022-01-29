package ar.com.educacionit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.EstadosOrdenes;
import ar.com.educacionit.repository.EstadosOrdenesRepository;
import ar.com.educacionit.services.EstadosOrdenesService;

@Service
public class EstadosOrdenesServiceImpl implements EstadosOrdenesService {

	@Autowired
	private EstadosOrdenesRepository repository;
	
	@Override
	public EstadosOrdenes getById(Long id) {
		return this.repository.getById(id);
	}

}
