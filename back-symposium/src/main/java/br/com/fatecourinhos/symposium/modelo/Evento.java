package br.com.fatecourinhos.symposium.modelo;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_evento", nullable = false, length = 20)
    private String nomeEvento;
    @Column(name = "descricao", nullable = false, length = 1000)
    private String descricao;
    @Column(name = "vagas_totais", nullable = false)
    private Long vagasTotais;
    @Column(name = "custo_inscricao", nullable = false)
    private BigDecimal custo;
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataIni;
    @Column(name = "data_final", nullable = false)
    private LocalDate dataFim;
    @Column(name = "numero_vagas_preenchidas")
    private Long numeroVagasPreechidas = 0L;
    @Column(name = "carga_horaria")
    private Long cargaHoraria;
    private String status;


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

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Long getNumeroVagasPreechidas() {
        return numeroVagasPreechidas;
    }

    public void setNumeroVagasPreechidas(Long numeroVagasPreechidas) {
        this.numeroVagasPreechidas = numeroVagasPreechidas;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionaParticipante(){
        this.numeroVagasPreechidas++;
    }

    public void retiraParticipante(){
        this.numeroVagasPreechidas--;
    }
}
