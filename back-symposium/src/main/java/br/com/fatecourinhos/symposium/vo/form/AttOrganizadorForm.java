package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;

public class AttOrganizadorForm {

    private String nome;
    private String cpf;
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Organizador atualiza (Long id, OrganizadorRepository repository){
        Organizador organizador = repository.getById(id);
        organizador.setTipo(this.tipo);
        organizador.setCpf(this.cpf);
        organizador.setNome(this.nome);

        repository.save(organizador);
        return organizador;
    }
}
