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
    @OneToMany(mappedBy = "participantes")
    private List<Certificado> certificados = new ArrayList<>();
}
