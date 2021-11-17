package br.com.fatecourinhos.symposium.config;

import br.com.fatecourinhos.symposium.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    //Pega o secret do Application.properties
    @Value("${symposium.jwt.secret}")
    private String secret;

    //Pega o expiration (tempo de expiração do Token) do Application.properties
    @Value("${symposium.jwt.expiration}")
    private String expiration;

    // Gera o token, utilizando a Autenticacao dos Dados de login
    public String gerarToken(Authentication auth){
        Usuario logado = (Usuario) auth.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("API do Symposium")
                .setSubject(logado.getUsername())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Verifica se o Token enviado no Header das requisições é válido
    public boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    // Pega o ID do usuário através do Token
    public String getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
