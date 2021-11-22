package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;
import br.com.fatecourinhos.symposium.vo.dto.OrganizadorDto;
import br.com.fatecourinhos.symposium.vo.form.AttOrganizadorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/organizador")
public class OrganizadorController {

    @Autowired
    OrganizadorRepository repository;

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OrganizadorDto> editaOrganizador(@PathVariable Long id, AttOrganizadorForm form){

        Organizador organizador = form.atualiza(id, repository);

        return ResponseEntity.ok().body(new OrganizadorDto(organizador));
    }

    @GetMapping("/{email}")
    @CrossOrigin
    public ResponseEntity getOrganizador(@PathVariable String email){
        Optional<Organizador> optOrganizador = repository.findByUsuarioEmail(email);

        if(optOrganizador.isPresent()){
            Organizador organizador = optOrganizador.get();

            return ResponseEntity.ok().body(new OrganizadorDto(organizador));
        }

        return ResponseEntity.badRequest().build();
    }
}
