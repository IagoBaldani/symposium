package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Optional<Participante> findByUsuario(String usuarioEmail);
}
