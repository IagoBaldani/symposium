package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {

    @Query(value = "SELECT * FROM organizador AS o WHERE o.usuario_email = :email", nativeQuery = true)
    Organizador findPorEmailDeUsuario(@Param("email") String email);
}
