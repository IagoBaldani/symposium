package br.com.fatecourinhos.symposium.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "organizador")
@Getter
@Setter
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
}
