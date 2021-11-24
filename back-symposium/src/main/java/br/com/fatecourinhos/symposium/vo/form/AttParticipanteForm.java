package br.com.fatecourinhos.symposium.vo.form;

import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import javassist.NotFoundException;

import java.util.Optional;

public class AttParticipanteForm {

    private String nome;
    private String cpf;
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void atualizar(Long id, ParticipanteRepository repository) throws NotFoundException {
        Optional<Participante> optParticipante = repository.findById(id);

        if(optParticipante.isPresent()){
            Participante participante = optParticipante.get();

            participante.setNome(this.nome);
            participante.setCpf(this.cpf);
            participante.setTipo(this.tipo);
            repository.save(participante);
        }
        else{
            throw new NotFoundException("O ID informado não foi encontrado!");
        }


    }
}
