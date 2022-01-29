package ar.com.educacionit.domain.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrdenesRequestDTO {

    private Integer cuponId;

    @NotNull
    private Long estadoOrdenId;

    @NotNull
    private Double montoTotal;

    @NotNull
    private Long socioId;

    public Integer getCuponId() {
        return cuponId;
    }

    public void setCuponId(Integer cuponId) {
        this.cuponId = cuponId;
    }

    public Long getEstadoOrdenId() {
        return estadoOrdenId;
    }

    public void setEstadoOrdenId(Long estadoOrdenId) {
        this.estadoOrdenId = estadoOrdenId;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Long getSocioId() {
        return socioId;
    }

    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }
}
