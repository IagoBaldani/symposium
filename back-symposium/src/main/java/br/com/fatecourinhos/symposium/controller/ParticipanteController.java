package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.vo.dto.ListaEventoDto;
import br.com.fatecourinhos.symposium.vo.dto.ParticipanteDto;
import br.com.fatecourinhos.symposium.vo.form.AttParticipantePorOrganizadorForm;
import br.com.fatecourinhos.symposium.vo.form.AttParticipantePorParticipanteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    ParticipanteRepository repository;

    @GetMapping("/{id}")
    public ParticipanteDto buscaParticipante (@PathVariable Long id){

        Optional<Participante> optional = repository.findById(id);

        if(optional.isPresent()){
            Participante participante = optional.get();

            return new ParticipanteDto(participante);
        }

        return null;
    }

    @PutMapping("/participante/{id}")
    @Transactional
    public ResponseEntity<ParticipanteDto> editaParticipantePorParticipante(@PathVariable Long id, AttParticipantePorParticipanteForm form){

        Participante participante = form.atualizar(id, repository);

        return ResponseEntity.ok().body(new ParticipanteDto(participante));
    }

    @PutMapping("/organizador/{id}")
    @Transactional
    public ResponseEntity<ParticipanteDto> editaParticipantePorOrganizador(@PathVariable Long id, AttParticipantePorOrganizadorForm form){

        Participante participante = form.atualizar(id, repository);

        return ResponseEntity.ok().body(new ParticipanteDto(participante));
    }

//    @GetMapping("/lista-de-eventos-inscritos")
//    public List<ListaEventoDto> listaEventosInscritos(){
//
//    }
}
