package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.vo.dto.ListaDeEventosInscritosDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaDeEventosInscritosDtoRepository extends JpaRepository<ListaDeEventosInscritosDto, Long> {

    @Query(value = "SELECT e.data_inicio, e.descricao, e.nome_evento, l.situacao " +
            "FROM lista_de_eventos_em_participantes AS l INNER JOIN eventos AS e ON l.fk_eventos = e.id " +
            "INNER JOIN participantes p on l.fk_participantes = p.id WHERE p.id = 3", nativeQuery = true)
    public List<ListaDeEventosInscritosDto> findByListaDeEventosInscritosPorParticipante(@Param("id") Long id);
}
