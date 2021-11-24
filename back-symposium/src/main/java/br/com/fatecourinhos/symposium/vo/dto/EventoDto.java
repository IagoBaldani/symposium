package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Evento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoDto {

    private String nomeEvento;
    private String descricao;
    private Long vagasTotais;
    private BigDecimal custo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Long cargaHoraria;
    private Long numeroVagasPreenchidas;
    private String status;

    public EventoDto() {
    }

    public EventoDto(Evento evento) {
        this.nomeEvento = evento.getNomeEvento();
        this.descricao = evento.getDescricao();
        this.vagasTotais = evento.getVagasTotais();
        this.custo = evento.getCusto();
        this.dataInicio = evento.getDataIni();
        this.dataFinal = evento.getDataFim();
        this.numeroVagasPreenchidas = evento.getNumeroVagasPreechidas();
        this.cargaHoraria = evento.getCargaHoraria();
        this.status = evento.getStatus();
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getVagasTotais() {
        return vagasTotais;
    }

    public void setVagasTotais(Long vagasTotais) {
        this.vagasTotais = vagasTotais;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Long getNumeroVagasPreenchidas() {
        return numeroVagasPreenchidas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumeroVagasPreenchidas(Long numeroVagasPreenchidas) {
        this.numeroVagasPreenchidas = numeroVagasPreenchidas;
    }
}
