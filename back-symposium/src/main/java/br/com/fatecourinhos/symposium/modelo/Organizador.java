package br.com.fatecourinhos.symposium.modelo;


import javax.persistence.*;

@Entity
@Table(name = "organizador")

public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_organizador", nullable = false, length = 60)
    private String nome;
    @Column(name = "email_organizador", nullable = false, length = 100)
    private String email;
    @Column(name = "curso_organizador", nullable = false, length = 100)
    private String curso;
    @Column(name = "cpf_organizador", nullable = false, length = 11)
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
