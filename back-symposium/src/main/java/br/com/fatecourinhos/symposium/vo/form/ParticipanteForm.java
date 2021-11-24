package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.UsuarioRepository;
import javassist.NotFoundException;

import java.util.Optional;

public class ParticipanteForm {

    private String nome;
    private String cpf;
    private String email;
    private String ra;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Participante converte (UsuarioRepository usuarioRepository) throws NotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(this.email);

        if(optionalUsuario.isPresent()){
            Participante participante = new Participante();
            participante.setUsuario(optionalUsuario.get());
            participante.setTipo(this.tipo);
            participante.setEmail(this.email);
            participante.setNome(this.nome);
            participante.setCpf(this.cpf);
            participante.setRa(this.ra);
            return participante;
        }
        else {
            throw new NotFoundException("Não foi encontrado nenhum usuário com o email!");
        }
    }
}
