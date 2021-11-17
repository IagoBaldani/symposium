package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByNome(String nome);
}
