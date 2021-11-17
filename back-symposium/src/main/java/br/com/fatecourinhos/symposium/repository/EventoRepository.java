package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query(value = "SELECT * FROM eventos AS e where e.status = 'EM_ANDAMENTO'", nativeQuery = true)
    List<Evento> findTodosPorStatus();
}
