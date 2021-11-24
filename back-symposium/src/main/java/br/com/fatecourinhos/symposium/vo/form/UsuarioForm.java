package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Usuario;

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

    public Usuario converte(String tipo){
        Usuario usuario = new Usuario();
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTipo(tipo);
        return usuario;
    }
}
