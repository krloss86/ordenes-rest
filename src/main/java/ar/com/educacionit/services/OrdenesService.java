package ar.com.educacionit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Ordenes;

@Service
public interface OrdenesService {

	public List<Ordenes> findAll();
	
	public Optional<Ordenes> getById(Long id);

	public void update(Ordenes cupon);

	public void delete(Long id);
	
	public Ordenes save(Ordenes ordenes);
}
