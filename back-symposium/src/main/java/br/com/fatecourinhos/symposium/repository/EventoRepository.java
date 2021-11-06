package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
