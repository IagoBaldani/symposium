package br.com.fatecourinhos.symposium.modelo;

import javax.persistence.*;

@Entity
@Table(name = "lista_de_inscritos_em_eventos")
public class ListaEventoParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_participantes", referencedColumnName = "id", nullable = false)
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "fk_eventos", referencedColumnName = "id", nullable = false)
    private Evento evento;
    @Column(name = "situacao")
    private String situacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
