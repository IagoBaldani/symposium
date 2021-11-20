package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Evento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoForm {

    private String nomeEvento;
    private String descricao;
    private Long vagasTotais;
    private BigDecimal custo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Long cargaHoraria;
    private String status;

    public Evento converte(){
        Evento evento = new Evento();
        evento.setNomeEvento(this.nomeEvento);
        evento.setCusto(this.custo);
        evento.setDescricao(this.descricao);
        evento.setVagasTotais(this.vagasTotais);
        evento.setDataFim(this.dataFinal);
        evento.setDataIni(this.dataInicio);
        evento.setCargaHoraria(this.cargaHoraria);
        evento.setStatus("EM_ANDAMENTO");
        return evento;
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
}
