package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Override
    Optional<Usuario> findById(String email);
}
