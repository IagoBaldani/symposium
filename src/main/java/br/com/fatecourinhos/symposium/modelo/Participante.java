package br.com.fatecourinhos.symposium.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participantes")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(name = "ra", nullable = false, length = 13)
    private String ra;
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    @OneToMany(mappedBy = "participante")

    private List<Certificado> certificados = new ArrayList<>();
    @ManyToMany(mappedBy = "evento")
    private List<Evento> eventos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
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

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
