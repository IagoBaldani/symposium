package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Evento;
import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.repository.EventoRepository;
import br.com.fatecourinhos.symposium.repository.ListaEventoParticipanteRepository;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeCertificadosDto;
import br.com.fatecourinhos.symposium.vo.form.InscricaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lista-evento-participante")
@CrossOrigin
public class ListaEventoParticipanteController {

    @Autowired
    ListaEventoParticipanteRepository repository;

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    @GetMapping("/lista-certificados/{id}")
    public List<ListaDeCertificadosDto> listaParaGerarCertificados (@PathVariable Long id){
        // Colocar lógica de verificação se o participante pagou a inscrição
        List<ListaEventoParticipante> listaEventoParticipante = repository.findPorIdParticipanteEDataMaisProxima(id);

        return ListaDeCertificadosDto.toList(listaEventoParticipante);
    }

    @PostMapping("/gera-inscricao")
    public ResponseEntity geraInscricaoNoEvento (@RequestBody InscricaoForm form){
        Long idParticipante = form.getIdParticipante();
        Long idEvento = form.getIdEvento();

        Optional<ListaEventoParticipante> optional = repository.findPorIdParticipanteEIdEvento(idParticipante,idEvento);

        if(!optional.isPresent()){

            ListaEventoParticipante lista = form.converte(eventoRepository, participanteRepository);
            repository.save(lista);

            //Lógica de alteração no número de participantes no evento
            try {
                Evento evento = eventoRepository.getById (idEvento);
                if (evento.getNumeroVagasPreechidas() < evento.getVagasTotais()) {
                    Long vagasPreenchidas = evento.getNumeroVagasPreechidas();
                    evento.setNumeroVagasPreechidas(vagasPreenchidas+1);
                    eventoRepository.save(evento);
                    return ResponseEntity.ok().body("Participante inscrito com sucesso!");
                }
                else{
                    return ResponseEntity.badRequest().body("O evento não tem mais vagas restantes");
                }
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e);
            }
        }

        return ResponseEntity.status(409).body("Este participante já está inscrito no evento selecionado!");
    }

    @PostMapping("/desinscricao/{id}")
    public ResponseEntity desinscricaoDoEvento(@PathVariable Long id){
        ListaEventoParticipante listaEventoParticipante = repository.getById(id);

        // Essa porra não tá funcionando não sei pq
        // (ERA P DIMINUIR A QTD DE VAGAS PREENCHIDAS AO DESINSCREVER UM PARTICIPANTE)
        Evento evento = listaEventoParticipante.getEvento();
        Long vagasPreenchidas = evento.getNumeroVagasPreechidas();
        evento.setNumeroVagasPreechidas(vagasPreenchidas - 1);
        eventoRepository.save(evento);

        repository.delete(listaEventoParticipante);
        return ResponseEntity.ok().body("Desinscrição feita com sucesso!");
    }
}
