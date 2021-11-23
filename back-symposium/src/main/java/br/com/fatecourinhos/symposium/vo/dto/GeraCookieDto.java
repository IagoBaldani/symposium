package br.com.fatecourinhos.symposium.vo.dto;

public class GeraCookieDto {

    private Long id;
    private String tipo;

    public GeraCookieDto (Long id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
