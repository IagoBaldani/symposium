package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {

    @Query(value = "SELECT * FROM organizador WHERE usuario_email = :email", nativeQuery = true)
    Optional<Organizador> findByUsuarioEmail(@Param("email") String email);
}
