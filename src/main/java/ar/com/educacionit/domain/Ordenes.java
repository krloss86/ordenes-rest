package ar.com.educacionit.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ar.com.educacionit.domain.enums.EstadoOrdenesEnum;

@Entity
@Table(name = "ordenes")
@JsonIgnoreProperties({"hibernateLazyInitializer"}) 
public class Ordenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_creacion")	
	private Date fechaCreacion;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "socios_id", referencedColumnName = "id")
	private Socios socio;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estados_ordenes_id", referencedColumnName = "id")
	private EstadosOrdenes estadoOrden;

	@OneToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "cupones_id", referencedColumnName = "id")
	private Cupones cupon;
	
	@NotNull
	@Column(name = "monto_total")
	Double montoTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Socios getSocio() {
		return socio;
	}
	public void setSocio(Socios socio) {
		this.socio = socio;
	}
	public EstadosOrdenes getEstadoOrden() {
		return estadoOrden;
	}
	public void setEstadoOrden(EstadosOrdenes estadoOrden) {
		this.estadoOrden = estadoOrden;
	}
	public Cupones getCupon() {
		return cupon;
	}
	public void setCupon(Cupones cupon) {
		this.cupon = cupon;
	}

	
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	@Override
	public String toString() {
		return "Ordenes [id=" + id + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordenes other = (Ordenes) obj;
		return Objects.equals(id, other.id);
	}
	
	public void anularOrden() {
		EstadosOrdenes anulada = new EstadosOrdenes();
		anulada.setId(EstadoOrdenesEnum.ANULADA.getEstado());		
		this.setEstadoOrden(anulada);
	}
}
