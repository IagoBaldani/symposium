package br.com.fatecourinhos.symposium.repository;

import br.com.fatecourinhos.symposium.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query(value = "SELECT * FROM usuarios AS u WHERE u.email = :email AND u.senha = :senha", nativeQuery = true)
    Optional<Usuario> findUsuarioPorEmailESenha(@Param("email") String email,@Param("senha") String senha);
}
