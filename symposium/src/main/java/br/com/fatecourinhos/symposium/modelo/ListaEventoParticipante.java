package br.com.fatecourinhos.symposium.modelo;

import javax.persistence.*;

@Entity
@Table(name = "lista_de_eventos_em_participantes")
public class ListaEventoParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fk_participantes")
    @JoinColumn(name = "fk_participantes", referencedColumnName = "id", nullable = false)
    private Long participanteFk;
    @Column(name = "fk_eventos")
    @JoinColumn(name = "fk_eventos", referencedColumnName = "id", nullable = false)
    private Long eventoFk;
    @Column(name = "situacao")
    private String situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParticipanteFk() {
        return participanteFk;
    }

    public void setParticipanteFk(Long participanteFk) {
        this.participanteFk = participanteFk;
    }

    public Long getEventoFk() {
        return eventoFk;
    }

    public void setEventoFk(Long eventoFk) {
        this.eventoFk = eventoFk;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
