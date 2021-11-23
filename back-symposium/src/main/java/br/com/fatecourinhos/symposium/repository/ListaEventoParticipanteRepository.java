package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ListaEventoParticipanteRepository extends JpaRepository<ListaEventoParticipante, Long> {


   @Query(value = "SELECT * FROM lista_de_inscritos_em_eventos AS p WHERE p.fk_participantes = :idParticipante", nativeQuery = true)
   List<ListaEventoParticipante> findTodosOsEventosInscritos(@Param("idParticipante") Long idParticipante);

   @Query(value = "SELECT lista.fk_participantes, lista.fk_eventos, lista.situacao, lista.id FROM lista_de_inscritos_em_eventos AS lista " +
           "INNER JOIN eventos AS e ON lista.fk_eventos = e.id WHERE lista.fk_participantes = :idParticipante AND e.data_final < :data", nativeQuery = true)
   ListaEventoParticipante findPorIdUsuarioESituacao(@Param("idParticipante")Long id, @Param("data")LocalDate data);

   @Query(value = "SELECT * FROM lista_de_inscritos_em_eventos AS lista " +
           "INNER JOIN participantes AS p ON lista.fk_participantes = p.id " +
           "INNER JOIN eventos as e ON lista.fk_eventos = e.id " +
           "WHERE p.id = :idPart AND e.status = 'FINALIZADO'", nativeQuery = true)
   List<ListaEventoParticipante> findPorIdParticipanteEDataMaisProxima(@Param("idPart") Long id);
}
