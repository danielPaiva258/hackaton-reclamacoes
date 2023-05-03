package br.com.fiap.hackaton.security.core;

import br.com.fiap.hackaton.security.models.PerfilAcessoDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;
    public JwtFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeaderToken =
                request.getHeader("Authorization");
        String username = null;
        if (authorizationHeaderToken != null &&
                authorizationHeaderToken.startsWith("Bearer ")) {
            try {
                username = jwtTokenUtil.getUsernameFromToken(authorizationHeaderToken);

            } catch (IllegalArgumentException illegal) {
                logger.info(illegal.getMessage());
            } catch (ExpiredJwtException expired) {
                logger.info(expired.getMessage());
            }
        } else {
            logger.warn("Token null ou fora do padrao Bearer");
        }
        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = getUserDetails(authorizationHeaderToken);
            UsernamePasswordAuthenticationToken authenticationToken = new
                    UsernamePasswordAuthenticationToken(userDetails,
                    null,
                    userDetails.getAuthorities());// Role
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }

    private UserDetails getUserDetails(String token) {

        Claims claim = jwtTokenUtil.parseClaims(token);
        ArrayList<PerfilAcessoDTO> perfilAcesso = new ArrayList<PerfilAcessoDTO>();
        perfilAcesso.add(new PerfilAcessoDTO((String) claim.get("roles")));
        return new org.springframework.security.core.userdetails.User(
                jwtTokenUtil.getUsernameFromToken(token),
                "",
                perfilAcesso);
    }

}
