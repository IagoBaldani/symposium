package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;

public class AttParticipanteForm {

    private String nome;
    private String email;
    private String cpf;
    private String tipo;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Participante atualizar(Long id, ParticipanteRepository repository){
        Participante participante = repository.getById(id);
        participante.setNome(this.nome);
        participante.setEmail(this.email);
        participante.setCpf(this.cpf);
        participante.setTipo(this.tipo);
        return participante;
    }
}
