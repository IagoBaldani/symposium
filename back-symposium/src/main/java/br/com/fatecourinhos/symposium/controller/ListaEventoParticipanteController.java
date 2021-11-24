package br.com.fatecourinhos.symposium.controller;

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
        List<ListaEventoParticipante> listaEventoParticipante = repository.findPorIdParticipanteEDataMaisProxima(id);

        return ListaDeCertificadosDto.toList(listaEventoParticipante);
    }


    @PostMapping("/gera-inscricao")
    public ResponseEntity geraInscricaoNoEvento (@RequestBody InscricaoForm form){

        ListaEventoParticipante lista = form.converte(eventoRepository, participanteRepository);
        repository.save(lista);

        return ResponseEntity.ok().build();
    }
}
