package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaEventoParticipanteRepository extends JpaRepository<ListaEventoParticipante, Long> {


   @Query(value = "SELECT * FROM lista_de_inscritos_em_eventos AS p WHERE p.fk_participantes = :idParticipante", nativeQuery = true)
   List<ListaEventoParticipante> findTodosOsEventosInscritos(@Param("idParticipante") Long idParticipante);
}
