package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Evento;
import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.repository.EventoRepository;
import br.com.fatecourinhos.symposium.vo.dto.EventoDto;
import br.com.fatecourinhos.symposium.vo.form.AtualizaEventoForm;
import br.com.fatecourinhos.symposium.vo.form.EventoForm;
import br.com.fatecourinhos.symposium.vo.form.ListaEventosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    EventoRepository repository;

    @GetMapping("/{id}")
    public EventoDto retornaEventoEspecifico(@PathVariable Long id){
        Optional<Evento> optional = repository.findById(id);

        if(optional.isPresent()){
            Evento evento = optional.get();
            return new EventoDto(evento);
        }
        return null;
    }

    @GetMapping("/lista-de-eventos")
    public List<ListaEventosDto> listaEventosParaParticipante (){
        List<Evento> listaDeEventos = repository.findTodosPorStatus();

        return ListaEventosDto.toList(listaDeEventos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EventoDto> criaEvento(@RequestBody EventoForm form, UriComponentsBuilder uriBuilder){
        Evento evento = form.converte();
        repository.save(evento);

        URI uri = uriBuilder.path("/api/evento/{id}").buildAndExpand(evento.getId()).toUri();

        return ResponseEntity.created(uri).body(new EventoDto(evento));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventoDto> atualizaEnvento(@PathVariable Long id ,@RequestBody AtualizaEventoForm form){
        Optional<Evento> optional = repository.findById(id);

        if(optional.isPresent()){
            Evento evento = form.atualizaEvento(id, repository);

            return ResponseEntity.ok().body(new EventoDto(evento));
        }

        return null;
    }

    @PutMapping("/altera-situacao/${id}")
    public ResponseEntity finalizaEvento (@PathVariable Long id){
        Optional<Evento> optional = repository.findById(id);
        if(optional.isPresent()){
            Evento evento = optional.get();

            if(evento.getStatus() == "FINALIZADO"){
                evento.setStatus("EM_ANDAMENTO");
                repository.save(evento);
            }else {
                evento.setStatus("FINALIZADO");
                repository.save(evento);
            }
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
