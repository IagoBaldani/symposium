package br.com.fatecourinhos.symposium.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome_evento", nullable = false, length = 20)
    private String nomeEvento;
    @Column(name = "descricao", nullable = false, length = 1000)
    private String descricao;
    @Column(name = "vagas_totais", nullable = false)
    private long vagasTotais;
    @Column(name = "custo", nullable = false)
    private BigDecimal custo;
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataIni;
    @Column(name = "data_final", nullable = false)
    private LocalDate dataFim;
    @OneToMany
    @JoinColumn(name = "id_participantes_fk", referencedColumnName = "id", nullable = false)
    private List<Participante> vagasPreenchidas = new ArrayList<>();
}
