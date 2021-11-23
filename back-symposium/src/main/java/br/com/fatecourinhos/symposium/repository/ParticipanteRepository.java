package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Optional<Participante> findByUsuario(String usuarioEmail);

    @Query(value = "SELECT * FROM participantes as p WHERE p.usuario_email = :email", nativeQuery = true)
    Participante findPorEmailDeUsuario(@Param("email") String email);
}
