package br.com.fatecourinhos.symposium.modelo;


import javax.persistence.*;

@Entity
@Table(name = "organizador")

public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false, length = 11)
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
        return this.usuario.getEmail();
    }
    public void setEmail(String email) {
        this.usuario.setEmail(email);
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
