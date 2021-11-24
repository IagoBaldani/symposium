package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Evento;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListaEventosDto {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private Long cargaHoraria;
    private Long vagasTotais;
    private Long vagasPreenchidas;

    public ListaEventosDto (Evento evento){
        this.id = evento.getId();
        this.nome = evento.getNomeEvento();
        this.descricao = evento.getDescricao();
        this.dataInicio = evento.getDataIni();
        this.cargaHoraria = evento.getCargaHoraria();
        this.vagasTotais = evento.getVagasTotais();
        this.vagasPreenchidas = evento.getNumeroVagasPreechidas();
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Long getVagasTotais() {
        return vagasTotais;
    }

    public void setVagasTotais(Long vagasTotais) {
        this.vagasTotais = vagasTotais;
    }

    public Long getVagasPreenchidas() {
        return vagasPreenchidas;
    }

    public void setVagasPreenchidas(Long vagasPreenchidas) {
        this.vagasPreenchidas = vagasPreenchidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static List<ListaEventosDto> toList (List<Evento> eventos){
        return eventos.stream().map(ListaEventosDto::new).collect(Collectors.toList());
    }
}
