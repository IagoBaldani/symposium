package br.com.fatecourinhos.symposium.modelo;

import javax.persistence.*;

@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Participante utilizadores;
}
