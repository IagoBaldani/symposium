package br.com.fatecourinhos.symposium.vo.dto;

public class TokenDto {

    private String tipo;
    private String token;
    private String tipoUsuario;
    private String emailUsuario;

    public TokenDto(String token, String tipo, String tipoUsuario, String emailUsuario) {
        this.token = token;
        this.tipo = tipo;
        this.tipoUsuario = tipoUsuario;
        this.emailUsuario = emailUsuario;
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
    public String getEmailUsuario() {
        return emailUsuario;
    }
}
