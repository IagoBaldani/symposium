package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Participante;

public class ParticipanteDto {

    private String nome;
    private String email;
    private String tipo;
    private String ra;
    private String cpf;

    public ParticipanteDto(Participante participante){
        this.nome = participante.getNome();
        this.email = participante.getEmail();
        this.tipo = participante.getTipo();
        this.ra = participante.getRa();
        this.cpf = participante.getCpf();
    }

    public ParticipanteDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
