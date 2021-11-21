package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ListaEventoParticipanteRepository;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeEventosInscritosPorParticipantesDto;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeParticipantesDto;
import br.com.fatecourinhos.symposium.vo.dto.ParticipanteDto;
import br.com.fatecourinhos.symposium.vo.form.AttParticipanteForm;
import br.com.fatecourinhos.symposium.vo.form.ParticipanteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    ParticipanteRepository repository;

    @Autowired
    ListaEventoParticipanteRepository listaEventoParticipanteRepository;

    @GetMapping
    public List<ListaDeParticipantesDto> listaParticipantes (){
        List<Participante> lista = repository.findAll();

        return ListaDeParticipantesDto.toList(lista);
    }

    @GetMapping("/{id}")
    public ParticipanteDto buscaParticipante (@PathVariable Long id){

        Optional<Participante> optional = repository.findById(id);

        if(optional.isPresent()){
            Participante participante = optional.get();

            return new ParticipanteDto(participante);
        }

        return null;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ParticipanteDto> editaParticipante(@PathVariable Long id, AttParticipanteForm form){

        Participante participante = form.atualizar(id, repository);

        return ResponseEntity.ok().body(new ParticipanteDto(participante));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ParticipanteDto> novoParticipante(ParticipanteForm form, UriComponentsBuilder UriBuilder){

        Participante participante = form.converte();
        repository.save(participante);

        URI uri = UriBuilder.path("/api/participante/{id}").buildAndExpand(participante.getId()).toUri();

        return ResponseEntity.created(uri).body(new ParticipanteDto(participante));
    }

    @GetMapping("/lista-de-eventos-inscritos/{id}")
    public List<ListaDeEventosInscritosPorParticipantesDto> listaEventosInscritosPorParticipante(@PathVariable Long id){

        List<ListaEventoParticipante> listaDeEventosPorParticipante = listaEventoParticipanteRepository.findTodosOsEventosInscritos(id);

        return ListaDeEventosInscritosPorParticipantesDto.toList(listaDeEventosPorParticipante);
    }
}
