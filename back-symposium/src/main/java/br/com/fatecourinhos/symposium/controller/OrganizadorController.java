package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;
import br.com.fatecourinhos.symposium.vo.dto.OrganizadorDto;
import br.com.fatecourinhos.symposium.vo.form.AttOrganizadorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/organizador")
@CrossOrigin
public class OrganizadorController {

    @Autowired
    OrganizadorRepository repository;

    @GetMapping("/{id}")
    public OrganizadorDto mostraOrganizador (@PathVariable Long id){
        return new OrganizadorDto(repository.getById(id));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editaOrganizador(@PathVariable Long id,@RequestBody AttOrganizadorForm form){

        Organizador organizador = form.atualiza(id, repository);

        return ResponseEntity.ok().build();
    }
}
