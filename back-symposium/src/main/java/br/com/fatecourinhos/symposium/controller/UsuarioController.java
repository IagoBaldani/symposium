package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.UsuarioRepository;
import br.com.fatecourinhos.symposium.vo.form.UsuarioForm;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.AlreadyBoundException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping("/{email}")
    public ResponseEntity getPadrao(@PathVariable String email){
        try{
            Optional<Usuario> optionalUsuario = repository.findById(email);

            if(optionalUsuario.isPresent()){
                return ResponseEntity.ok().body(optionalUsuario.get());
            }
            else{
                throw new NotFoundException(email);
            }
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity cadastroUsuario(@RequestBody UsuarioForm form){
        Optional<Usuario> optionalUsuario = repository.findById(form.getEmail());

        try {
            if(!optionalUsuario.isPresent()) {
                Usuario usuario = form.converte("PARTICIPANTE");
                repository.save(usuario);

                return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
            }
            else {
                throw new AlreadyBoundException("Este email já está sendo utilizado por outro usuário");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
