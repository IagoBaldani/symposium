package br.com.fatecourinhos.symposium.controller;

import br.com.fatecourinhos.symposium.config.AutenticacaoService;
import br.com.fatecourinhos.symposium.config.TokenService;
import br.com.fatecourinhos.symposium.modelo.Perfil;
import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.PerfilRepository;
import br.com.fatecourinhos.symposium.vo.dto.TokenDto;
import br.com.fatecourinhos.symposium.vo.form.AutenticacaoForm;
import br.com.fatecourinhos.symposium.vo.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Essa classe é o controller que recebe requisições para o retorno do Token JWT
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private AutenticacaoService authService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    // Esse método recebe as requisições e autentica os dados presentes no Body
    // Caso os dados (Email e Senha) coincidem com os presentes no BD, o método retorna
    // o Token para utilização da API, o tipo do usuário e o tipo do Token.
    public ResponseEntity autenticar(@RequestBody @Valid AutenticacaoForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            List<Perfil> perfis = (List<Perfil>) authentication.getAuthorities();
            Perfil perfil = perfis.get(0);

            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer", perfil.getNome()));
        }
        catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    // Esse método recebe o token armazenado no FrontEnd e retorna uma String com o resultado
    // da verificação do Token
    @GetMapping("/{token}")
    public String verificaToken(@PathVariable String token){
        if(tokenService.isTokenValido(token)){
            return "SUCESSO";
        }

        return "ERRO";
    }

    @PostMapping("/cadastro-usuario")
    public ResponseEntity cadastroUsuario(@RequestBody UsuarioForm form){
        Usuario usuario = form.converter(perfilRepository);

        try{
            authService.salvaUsuario(usuario);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
