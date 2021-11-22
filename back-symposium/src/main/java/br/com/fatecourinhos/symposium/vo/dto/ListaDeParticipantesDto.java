package br.com.fatecourinhos.symposium.vo.dto;

import br.com.fatecourinhos.symposium.modelo.Participante;

import java.util.List;
import java.util.stream.Collectors;

public class ListaDeParticipantesDto {

    private String nome;
    private String ra;

    public ListaDeParticipantesDto(Participante participante){
        this.nome = participante.getNome();
        this.ra = participante.getRa();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public static List<ListaDeParticipantesDto> toList (List<Participante> lista){
        return lista.stream().map(ListaDeParticipantesDto::new).collect(Collectors.toList());
    }
}
