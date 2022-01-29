package ar.com.educacionit.domain.enums;

public enum EstadoOrdenesEnum {

	INICIAL(1l,"INICIAL"),
	FINAL(2L,"FINAL"),
	ANULADA(3L,"ANULADA");
	
	private Long estado;
	private String descripcion;
	
	private EstadoOrdenesEnum(Long estado,String descripcion) {
		this.estado = estado;
		this.descripcion = descripcion;
	}
	
	public Long getEstado() {
		return this.estado;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
