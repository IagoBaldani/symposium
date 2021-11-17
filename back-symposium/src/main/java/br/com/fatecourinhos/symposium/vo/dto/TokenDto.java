package br.com.fatecourinhos.symposium.vo.dto;

public class TokenDto {

    private String tipo;
    private String token;
    private String tipoUsuario;

    public TokenDto(String token, String tipo, String tipoUsuario) {
        this.token = token;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public String getTipo() {
        return tipo;
    }
    public String getToken() {
        return token;
    }
}
