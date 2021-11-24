package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDeCertificadosDto {

    private Long id;
    private String nomeEvento;
    private String nomeParticipante;
    private Long cargaHoraria;
    private LocalDate dataFim;

    public ListaDeCertificadosDto (ListaEventoParticipante listaEventoParticipante){
        this.id = listaEventoParticipante.getId();
        this.nomeEvento = listaEventoParticipante.getEvento().getNomeEvento();
        this.nomeParticipante = listaEventoParticipante.getParticipante().getNome();
        this.cargaHoraria = listaEventoParticipante.getEvento().getCargaHoraria();
        this.dataFim = listaEventoParticipante.getEvento().getDataFim();
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

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Long cargaHoraria) {
        cargaHoraria = cargaHoraria;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public static List<ListaDeCertificadosDto> toList(List<ListaEventoParticipante> lista){
        return lista.stream().map(ListaDeCertificadosDto::new).collect(Collectors.toList());
    }
}
