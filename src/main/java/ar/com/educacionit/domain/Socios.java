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
import javax.persistence.Table;

@Table(name = "socios")
@Entity
public class Socios {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fecha_alta")
	private Date fechaAlta;

	@Column(name = "direccion")
	private String direccion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paises_id", referencedColumnName = "id")
	private Paises pais;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
		
	@Override
	public String toString() {
		return "Socios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fechaAlta=" + fechaAlta + ", direccion=" + direccion + ", pais=" + pais + "]";
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
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
		Socios other = (Socios) obj;
		return Objects.equals(id, other.id);
	}
	
}
