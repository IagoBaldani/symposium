package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;

public class ListaDeCertificadosDto {

    private Long id;
    private String nomeEvento;

    public ListaDeCertificadosDto (ListaEventoParticipante listaEventoParticipante){
        this.id = listaEventoParticipante.getId();
        this.nomeEvento = listaEventoParticipante.getEvento().getNomeEvento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
}
