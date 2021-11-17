package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Perfil;
import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.PerfilRepository;

import java.util.Optional;

public class UsuarioForm {
    private String email;
    private String senha;
    private String tipoUsuario;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario converter(PerfilRepository perfilRepository){
        Optional<Perfil> optPerfil = perfilRepository.findByNome(this.tipoUsuario);

        return new Usuario(email, senha, optPerfil.get());
    }

}
