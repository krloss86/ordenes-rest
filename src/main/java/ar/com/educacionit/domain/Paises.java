package ar.com.educacionit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "paises")
@Entity
public class Paises {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "descripcion_corta")
	private String descripcionCorta;
	
	@Column(name = "habilitada")
	private Long habilitada;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	
	public Long getHabilitada() {
		return habilitada;
	}
	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}
	
	@Override
	public String toString() {
		return "Paises [id=" + id + ", descripcion=" + descripcion + ", descripcionCorta=" + descripcionCorta + "]";
	}
	
}
