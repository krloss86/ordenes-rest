package ar.com.educacionit.domain.recources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import ar.com.educacionit.domain.Cupones;
import ar.com.educacionit.domain.EstadosOrdenes;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.request.OrdenesRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.domain.enums.EstadoOrdenesEnum;
import ar.com.educacionit.services.OrdenesService;
import io.swagger.annotations.ApiOperation;

@RestController
public class OrdenesRecources {

	@Autowired
	private OrdenesService service;
	
	@ApiOperation(value = "Consula de Ordenes por id")
	@GetMapping(value="/orden/{id}", produces = "application/json")
	public ResponseEntity<Ordenes> get(
			@PathVariable(name="id", required= true) Long id) {
		
		//usar un servicio
		Optional<Ordenes> orden = this.service.getById(id);
		
		if(!orden.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//retorna la respuesta
		return ResponseEntity.ok(orden.get());
	}
	
	@PostMapping("/orden")
	public ResponseEntity<Ordenes> post(@Valid @RequestBody OrdenesRequestDTO orden) throws URISyntaxException{
		
		Ordenes ordenDB = null;
		String path = "/orden/";
		
		if(orden.getEstadoOrdenId() != null) {
			Optional<Ordenes> ordenOptional = this.service.getById(orden.getEstadoOrdenId());
			if(!ordenOptional.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			ordenDB = ordenOptional.get();
			path += ordenDB.getId();

		}else {

			Ordenes nuevaOrden = new Ordenes();

			EstadosOrdenes eo = new EstadosOrdenes();
			eo.setId(orden.getEstadoOrdenId());
			nuevaOrden.setEstadoOrden(eo);

			if(orden.getCuponId()!=null){
				Cupones cuponAsociado = new Cupones();
				cuponAsociado.setId(orden.getCuponId());
				nuevaOrden.setCupon(cuponAsociado);
			}
			Socios socio = new Socios();
			socio.setId(orden.getSocioId());
			nuevaOrden.setSocio(socio);

			nuevaOrden.setFechaCreacion(new Date());

			nuevaOrden.setMontoTotal(orden.getMontoTotal());

			this.service.save(nuevaOrden);
			path += orden.getEstadoOrdenId();
		}
		
		return ResponseEntity.created(new URI(path)).build() ;
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@PutMapping(value="/orden/{id}", produces = "application/json",consumes = "application/json")
	public ResponseEntity<Ordenes> put(
			@PathVariable(name="id") Long id, 
			@RequestBody Ordenes orden
			) {
		
		//validaciones de formato: las hace el framework
		
		Optional<Ordenes> ordenOptional = this.service.getById(id);
		
		//existencia
		if(!ordenOptional.isPresent()) {
			//404 recurso inexistente
			return ResponseEntity.notFound().build();
		}
		
		Ordenes ordenFromDb = ordenOptional.get(); 
		
		if(!orden.getId().equals(ordenFromDb.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
		ordenFromDb.setEstadoOrden(orden.getEstadoOrden());
		// mas datos depende del negocio
		
		if(orden.getCupon() != null && !orden.getCupon().equals(ordenFromDb.getCupon())) {
			ordenFromDb.setCupon(orden.getCupon());
		}
		
		if(!orden.getSocio().equals(ordenFromDb.getSocio())) {
			ordenFromDb.setSocio(orden.getSocio());
		}
		
		this.service.update(ordenFromDb);
		
		//si sale todo ok, 200
		return ResponseEntity.ok(ordenFromDb);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/orden/{id}")
	public ResponseEntity<Void> delete(
			@PathVariable(name="id",required = true) Long id
		) {
		
		Optional<Ordenes> ordenOptional = this.service.getById(id);
		
		if(!ordenOptional.isPresent()) {
			return ResponseEntity.ok().build();
		}
		
		Ordenes orden = ordenOptional.get();
		
		if(orden.getEstadoOrden().getId().equals(EstadoOrdenesEnum.ANULADA.getEstado())) {
			return ResponseEntity.ok(null);
		}
		
		orden.anularOrden();
		
		this.service.update(orden);
		
		return ResponseEntity.ok(null);
	}

	//java collection framework
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		//armar todo el mapa
		Map<String,String> errores = new HashMap<>();
		
		for(ObjectError err : ex.getAllErrors()) {
			FieldError field = (FieldError)err;
			String fieldName = field.getField();
			String msj = err.getDefaultMessage();
			errores.put(fieldName, msj);			
		}
		
		return errores;
	}
}
