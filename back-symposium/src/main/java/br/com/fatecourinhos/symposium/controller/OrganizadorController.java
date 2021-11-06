package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Organizador;
import br.com.fatecourinhos.symposium.repository.OrganizadorRepository;
import br.com.fatecourinhos.symposium.vo.dto.OrganizadorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

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
}
