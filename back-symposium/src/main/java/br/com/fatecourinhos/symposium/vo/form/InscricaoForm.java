package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.repository.EventoRepository;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;

public class InscricaoForm {

    private Long idParticipante;
    private Long idEvento;
    private String situacao;


    public Long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        situacao = situacao;
    }

    public ListaEventoParticipante converte (EventoRepository eventoRepository, ParticipanteRepository participanteRepository){
        ListaEventoParticipante lista = new ListaEventoParticipante();

        lista.setSituacao("PAGAMENTO_PENDENTE");
        lista.setEvento(eventoRepository.getById(this.idEvento));
        lista.setParticipante(participanteRepository.getById(this.idParticipante));

        return lista;
    }
}
