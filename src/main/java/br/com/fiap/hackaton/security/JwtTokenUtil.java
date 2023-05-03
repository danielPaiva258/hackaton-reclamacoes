package br.com.fiap.hackaton.security;

import br.com.fiap.hackaton.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private int expire;

    public String generateToken(Usuario usr){
        Map<String, Object> claims = new HashMap<>(); // Roles

        claims.put("roles", usr.getPerfisAcesso().get(0).getAuthority());
        Date dataCriacao = getFromLocalDate(LocalDateTime.now());
        Date dataExpiracao =
                getFromLocalDate(LocalDateTime.now().plusMinutes(expire));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .setSubject(usr.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    private Date getFromLocalDate(LocalDateTime now) {
        return Date.from(now.toInstant(OffsetDateTime.now().getOffset()));
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }

    public Claims parseClaims(String token) {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
    }
}
