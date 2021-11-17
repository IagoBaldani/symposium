package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;

public class AttOrganizadorForm {

    private String nome;
    private String cpf;
    private String email;
    private String tipo;

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

    public Organizador atualiza (Long id, OrganizadorRepository repository){
        Organizador organizador = repository.getById(id);
        organizador.setEmail(this.email);
        organizador.setTipo(this.tipo);
        organizador.setEmail(this.email);
        organizador.setNome(this.nome);

        return organizador;
    }
}
