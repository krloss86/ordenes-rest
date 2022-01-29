package ar.com.educacionit.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.repository.OrdenesRepository;
import ar.com.educacionit.services.OrdenesService;

@Service
public class OrdenesServiceImpl implements OrdenesService {

	@Autowired
	private OrdenesRepository repository;
	
	public List<Ordenes> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Ordenes> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void update(Ordenes cupon) {
		this.repository.save(cupon);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	@Override
	public Ordenes save(Ordenes ordenes) {
		return this.repository.save(ordenes);
	}
}
