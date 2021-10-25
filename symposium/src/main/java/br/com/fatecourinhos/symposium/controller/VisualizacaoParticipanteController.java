package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.vo.dto.ParticipanteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/visualiza-participante")
public class VisualizacaoParticipanteController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @GetMapping
    public String visualizarParticipante(Model model){
        Participante participante = participanteRepository.getById(new Long(2));

            ParticipanteDto participanteDto = new ParticipanteDto(participante);

            model.addAttribute("participante", participanteDto);

            return "visualizacaoParticipante";

    }
}
