package br.com.fatecourinhos.symposium.config;

import br.com.fatecourinhos.symposium.modelo.Usuario;
import br.com.fatecourinhos.symposium.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


// Esse filter é o filtro que faz a verificação do Token enviado em todas as requisições para a API
public class AutenticacaoTokenFilter extends OncePerRequestFilter {

    // Por ser uma classe Filter, não tem como utilizar a anotação Autowired
    // portanto, injetamos a classe Token Service e o UsuarioAcessoRepository por meio de construtor
    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    // Esse método é o método principal desse filter
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);

        // Caso o token seja válido, aqui ocorre a autenticação do usuário que está o utilizando.
        if(valido){
            autenticarUsuario(token);
        }

        filterChain.doFilter(request, response);
    }

    // Esse método recupera o token passado no Header de cada requisição.
    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }

        return token.substring(7, token.length());
    }

    // Define que o usuário está autenticado
    private void autenticarUsuario(String token) {
        String idUsuario = tokenService.getIdUsuario(token);
        Optional<Usuario> optUsuario = usuarioRepository.findById(idUsuario);

        Usuario usuario = optUsuario.get();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}