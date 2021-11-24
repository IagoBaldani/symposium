package br.com.fatecourinhos.symposium.vo.form;


import br.com.fatecourinhos.symposium.modelo.Evento;
import br.com.fatecourinhos.symposium.repository.EventoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AtualizaEventoForm {

    private String nome;
    private String descricao;
    private Long vagasTotais;
    private BigDecimal custo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Long cargaHoraria;
    private String status;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public Evento atualizaEvento(Long id, EventoRepository repository) {

        Evento evento = repository.getById(id);
        evento.setNomeEvento(this.nome);
        evento.setDescricao(this.descricao);
        evento.setCusto(this.custo);
        evento.setVagasTotais(this.vagasTotais);
        evento.setDataIni(this.dataInicio);
        evento.setDataFim(this.dataFinal);
        evento.setCargaHoraria(this.cargaHoraria);
        evento.setStatus("EM_ANDAMENTO");

        return evento;
    }
}
