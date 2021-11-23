package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.modelo.Participante;
import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;
import br.com.fatecourinhos.symposium.repository.ParticipanteRepository;
import br.com.fatecourinhos.symposium.repository.UsuarioRepository;
import br.com.fatecourinhos.symposium.vo.dto.GeraCookieDto;
import br.com.fatecourinhos.symposium.vo.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    ParticipanteRepository participanteRepository;

    @Autowired
    OrganizadorRepository organizadorRepository;

    @PostMapping
    public ResponseEntity<GeraCookieDto> loginNoSistema(@RequestBody LoginForm form){

        Optional<Usuario> optional = repository.findUsuarioPorEmailESenha(form.getEmail(), form.getSenha());

        if(optional.isPresent()){
            Usuario usuario = optional.get();

            if(Objects.equals(usuario.getTipo(), "ORGANIZADOR")){
                Organizador organizador = organizadorRepository.findPorEmailDeUsuario(usuario.getEmail());
                return ResponseEntity.ok().body(new GeraCookieDto(organizador.getId(), "ORGANIZADOR"));
            }else {
                Participante participante = participanteRepository.findPorEmailDeUsuario(usuario.getEmail());
                return ResponseEntity.ok().body(new GeraCookieDto(participante.getId(), "PARTICIPANTE"));
            }

        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
