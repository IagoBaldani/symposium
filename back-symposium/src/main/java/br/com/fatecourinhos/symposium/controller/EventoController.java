package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Evento;
import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.repository.EventoRepository;
import br.com.fatecourinhos.symposium.vo.dto.EventoDto;
import br.com.fatecourinhos.symposium.vo.form.AtualizaEventoForm;
import br.com.fatecourinhos.symposium.vo.form.EventoForm;
import br.com.fatecourinhos.symposium.vo.dto.ListaEventosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin
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
    public List<ListaEventosDto> listaEventos (){
        List<Evento> listaDeEventos = repository.findTodosPorStatus();

        return ListaEventosDto.toList(listaDeEventos);
    }

//    //PENDENTE - DEVE RETORNAR UMA LISTA COM OS EVENTOS NO QUAL O PARTICIPANTE NÃO ESTÁ INSCRITO
//    @GetMapping("/lista-de-eventos-nao-inscritos/{$id}")
//    public List<ListaEventosDto> listaEventosNaoInscritos(@PathVariable Long id){
//
//    }

    @PostMapping
    @Transactional
    public ResponseEntity criaEvento(@RequestBody EventoForm form) {
        try {
            Evento evento = form.converte();
            repository.save(evento);

            return ResponseEntity.ok().body("Cadastro de evento concluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventoDto> atualizaEvento(@PathVariable Long id,@RequestBody AtualizaEventoForm form){
        Optional<Evento> optional = repository.findById(id);

        if(optional.isPresent()){
            Evento evento = form.atualizaEvento(id, repository);

            return ResponseEntity.ok().body(new EventoDto(evento));
        }

        return null;
    }

    @PutMapping("/altera-situacao/{id}")
    public ResponseEntity alteraSItuacao (@PathVariable Long id){
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

    @PostMapping("/deletar-evento/{id}")
    @Transactional
    public ResponseEntity terminarEvento(@PathVariable Long id){
        Optional<Evento> optional = repository.findById(id);

        if(optional.isPresent()){
            Evento evento = optional.get();
            if (evento.getNumeroVagasPreechidas() == 0) {
                repository.deleteById(id);
                return ResponseEntity.ok().body("Evento excluído com sucesso!");
            } else{
                return ResponseEntity.badRequest().body("O evento possui inscritos!");
            }
        }

        return ResponseEntity.badRequest().body("Não há nenhum evento com o ID informado!");
    }
}
