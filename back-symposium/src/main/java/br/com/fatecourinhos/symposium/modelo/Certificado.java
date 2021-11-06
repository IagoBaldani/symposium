package br.com.fatecourinhos.symposium.modelo;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fk_participante")
    @JoinColumn(name = "fk_participante", referencedColumnName = "id", nullable = false)
    private Long participanteFk;
    @Column(name = "fk_eventos")
    @JoinColumn(name = "fk_eventos", referencedColumnName = "id", nullable = false)
    private Long eventosFk;


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

    public Long getEventosFk() {
        return eventosFk;
    }

    public void setEventosFk(Long eventosFk) {
        this.eventosFk = eventosFk;
    }
}
