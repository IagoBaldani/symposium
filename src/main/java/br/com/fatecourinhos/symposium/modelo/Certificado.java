package br.com.fatecourinhos.symposium.modelo;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Participante participante;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(name = "hora_conclusao", nullable = false)
    private LocalDate horaConclusao;


}
