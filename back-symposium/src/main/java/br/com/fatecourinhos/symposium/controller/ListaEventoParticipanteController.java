package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.ListaEventoParticipante;
import br.com.fatecourinhos.symposium.repository.ListaEventoParticipanteRepository;
import br.com.fatecourinhos.symposium.vo.dto.ListaDeCertificadosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/lista-evento-participante")
public class ListaEventoParticipanteController {

    @Autowired
    ListaEventoParticipanteRepository repository;

    @GetMapping("/lista-certificados/${id}")
    public List<ListaDeCertificadosDto> listaParaGerarCertificados (@PathVariable Long id){
        LocalDate data = LocalDate.now();
        ListaEventoParticipante listaEventoParticipante = repository.findPorIdUsuarioESituacao(id, data);
    }

    @GetMapping("/gera-certificados/${id}")
    public CertificadoDto geraCertificado (@PathVariable Long id){

    }

    @PostMapping
    public InscricaoGeradaDto geraInscricaoNoEvento (@RequestBody)
}
