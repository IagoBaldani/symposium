package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Organizador;

public class OrganizadorDto {

    private String nome;
    private String cpf;
    private String email;
    private String tipo;

    public OrganizadorDto(Organizador organizador){
        this.nome = organizador.getNome();
        this.cpf = organizador.getCpf();
        this.tipo = organizador.getTipo();
        this.email = organizador.getEmail();
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
