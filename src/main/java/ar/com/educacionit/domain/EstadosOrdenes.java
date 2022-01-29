package ar.com.educacionit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "estados_ordenes")
@Entity
public class EstadosOrdenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "descripcion_corta")
	private String descripcionCorta;
	
	@Column(name = "estado_final")
	private Long estadoFinal;
	
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

	public Long getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(Long estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	
	@Override
	public String toString() {
		return "EstadosOrdenes [id=" + id + ", descripcion=" + descripcion + ", estadoFinal=" + estadoFinal + "]";
	}
	
}
