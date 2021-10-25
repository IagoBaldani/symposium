package br.com.fatecourinhos.symposium.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "participantes")
@Getter
@Setter
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
//    @Column(name = "tipo", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Tipo tipo = Tipo.ALUNO;
    @Column(name = "ra", nullable = false, length = 13)
    private String ra;
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    @OneToMany(mappedBy = "participante")
    private List<Certificado> certificados = new ArrayList<>();
    @ManyToMany
    @JoinColumn(name = "eventos", referencedColumnName = "id", nullable = false)
    private List<Evento> eventos = new ArrayList<>();
}
