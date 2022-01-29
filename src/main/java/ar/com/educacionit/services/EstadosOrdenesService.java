package ar.com.educacionit.services;

import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.EstadosOrdenes;

@Service
public interface EstadosOrdenesService {

	public EstadosOrdenes getById(Long id);
}
