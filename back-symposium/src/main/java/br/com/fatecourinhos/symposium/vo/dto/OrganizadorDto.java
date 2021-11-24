package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Organizador;

public class OrganizadorDto {

    private String nome;
    private String cpf;
    private String email;
    private String tipo;

    public OrganizadorDto(Organizador organizador){
        this.cpf = organizador.getCpf();
        this.nome = organizador.getNome();
        this.email = organizador.getUsuario().getEmail();
        this.tipo = organizador.getTipo();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
