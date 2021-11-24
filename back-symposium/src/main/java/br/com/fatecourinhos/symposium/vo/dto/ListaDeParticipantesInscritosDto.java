package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;

import java.util.List;
import java.util.stream.Collectors;

public class ListaDeParticipantesInscritosDto {

    private Long idDaInscricao;
    private String nomeEvento;
    private String nome;
    private String ra;
    private String status;

    public ListaDeParticipantesInscritosDto(ListaEventoParticipante listaEventoParticipante){
        this.nomeEvento = listaEventoParticipante.getEvento().getNomeEvento();
        this.idDaInscricao = listaEventoParticipante.getId();
        this.nome = listaEventoParticipante.getParticipante().getNome();
        this.ra = listaEventoParticipante.getParticipante().getRa();
        this.status = listaEventoParticipante.getSituacao();
    }

    public static List<ListaDeParticipantesInscritosDto> toList(List<ListaEventoParticipante> listaEventoParticipante) {
        return listaEventoParticipante.stream().map(ListaDeParticipantesInscritosDto::new).collect(Collectors.toList());
    }

    public Long getIdDaInscricao() {
        return idDaInscricao;
    }

    public void setIdDaInscricao(Long idDaInscricao) {
        this.idDaInscricao = idDaInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
}
