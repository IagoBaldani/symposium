package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Evento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoDto {

    private String nomeEvento;
    private String descricao;
    private long vagasTotais;
    private BigDecimal custo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public EventoDto() {
    }

    public EventoDto(Evento evento) {
        this.nomeEvento = evento.getNomeEvento();
        this.descricao = evento.getDescricao();
        this.vagasTotais = evento.getVagasTotais();
        this.custo = evento.getCusto();
        this.dataInicio = evento.getDataIni();
        this.dataFinal = evento.getDataFim();
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

    public long getVagasTotais() {
        return vagasTotais;
    }

    public void setVagasTotais(long vagasTotais) {
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
}
