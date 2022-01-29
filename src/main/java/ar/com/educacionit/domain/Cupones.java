package ar.com.educacionit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cupones")
public class Cupones {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "fecha_vigencia_desde")
	private Date fechaVigenciaDesde;
	
	@Column(name = "fecha_vigencia_hasta")	
	private Date fechaVigenciaHasta;
	
	@Column(name = "descuento")
	private Double descuento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	public void setFechaVigenciaDesde(Date fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	public Date getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	public void setFechaVigenciaHasta(Date fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Cupones [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", fechaVigenciaDesde="
				+ fechaVigenciaDesde + ", fechaVigenciaHasta=" + fechaVigenciaHasta + ", descuento=" + descuento + "]";
	}
    
}
