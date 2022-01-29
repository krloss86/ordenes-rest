package ar.com.educacionit.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";

    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }
}
