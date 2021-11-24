package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ListaEventoParticipanteRepository;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.repository.UsuarioRepository;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeEventosInscritosPorParticipanteDto;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeParticipantesDto;
import br.com.fatecourinhos.symposium.vo.dto.ParticipanteDto;
import br.com.fatecourinhos.symposium.vo.form.AttParticipanteForm;
import br.com.fatecourinhos.symposium.vo.form.ParticipanteForm;
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
    ParticipanteRepository participanteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ListaEventoParticipanteRepository listaEventoParticipanteRepository;

    @GetMapping
    public List<ListaDeParticipantesDto> listaParticipantes (){
        List<Participante> lista = participanteRepository.findAll();

        return ListaDeParticipantesDto.toList(lista);
    }

    @GetMapping("/{id}")
    public ParticipanteDto buscaParticipante (@PathVariable Long id){

        Optional<Participante> optional = participanteRepository.findById(id);

        if(optional.isPresent()){
            Participante participante = optional.get();

            return new ParticipanteDto(participante);
        }

        return null;
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity editaParticipante(@PathVariable Long id, @RequestBody AttParticipanteForm form){
        try {
            form.atualizar(id, participanteRepository);

            return ResponseEntity.ok().body("Participante editado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro na edição do participante - " + e);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity novoParticipante(@RequestBody ParticipanteForm form){
        try{
            Participante participante = form.converte(usuarioRepository);
            participanteRepository.save(participante);
            return ResponseEntity.ok().body("Participante cadastrado com sucesso!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/lista-de-eventos-inscritos/{id}")
    public List<ListaDeEventosInscritosPorParticipanteDto> listaEventosInscritosPorParticipante(@PathVariable Long id){

        List<ListaEventoParticipante> listaDeEventosPorParticipante = listaEventoParticipanteRepository.findTodosOsEventosInscritosEmAndamento(id);

        return ListaDeEventosInscritosPorParticipanteDto.toList(listaDeEventosPorParticipante);
    }

    @PostMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity deletaParticipante(@PathVariable Long id){
        Optional<Participante> optionalParticipante = participanteRepository.findById(id);

        if(optionalParticipante.isPresent()){
            participanteRepository.deleteById(id);
            return ResponseEntity.ok().body("Participante excluído com sucesso!");
        }

        return ResponseEntity.badRequest().body("Não há nenhum participante com o ID informado!");
    }
}
