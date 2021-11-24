package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeEventosInscritosPorParticipanteDto {

    private Long idParticipante;
    private String nomeParticipante;
    private Long idEvento;
    private String nomeEvento;
    private String situacao;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long cargaHoraria;
    private Long idInscricao;

    public ListaDeEventosInscritosPorParticipanteDto(ListaEventoParticipante listaEventoParticipante){
        this.idParticipante = listaEventoParticipante.getParticipante().getId();
        this.idEvento = listaEventoParticipante.getEvento().getId();
        this.nomeEvento = listaEventoParticipante.getEvento().getNomeEvento();
        this.nomeParticipante = listaEventoParticipante.getParticipante().getNome();
        this.situacao = listaEventoParticipante.getSituacao();
        this.descricao = listaEventoParticipante.getEvento().getDescricao();
        this.dataInicio = listaEventoParticipante.getEvento().getDataIni();
        this.dataFim = listaEventoParticipante.getEvento().getDataFim();
        this.cargaHoraria = listaEventoParticipante.getEvento().getCargaHoraria();
        this.idInscricao = listaEventoParticipante.getId();
    }

    public Long getIdParticipante() {
        return idParticipante;
    }
    public void setIdParticipante(Long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }
    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public Long getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Long getIdInscricao() {
        return idInscricao;
    }
    public void setIdInscricao(Long idInscricao) {
        this.idInscricao = idInscricao;
    }

    public static List<ListaDeEventosInscritosPorParticipanteDto> toList (List<ListaEventoParticipante> lista){
        return lista.stream().map(ListaDeEventosInscritosPorParticipanteDto::new).collect(Collectors.toList());
    }
}
