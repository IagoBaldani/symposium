package br.com.fatecourinhos.symposium.vo.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutenticacaoForm {

    @NotEmpty @NotNull
    private String email;

    @NotEmpty @NotNull
    private String senha;

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

}
