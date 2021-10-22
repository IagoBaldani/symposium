package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Participante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ParticipanteDto {

    private String nome;
    private String email;
    //private String tipoUsuario;
    private String ra;
    private String cpf;

    public ParticipanteDto(Participante participante){
        this.nome = participante.getNome();
        this.email = participante.getEmail();
        //this.tipoUsuario = String.valueOf(participante.getTipo());
        this.ra = participante.getRa();
        this.cpf = participante.getCpf();
    }
}
