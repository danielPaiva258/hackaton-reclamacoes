package br.com.fiap.hackaton.security.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

    private final String ROLE_CLIENTE = "CLIENTE";
    private final String ROLE_ATENDENTE = "ATENDENTE";
    private final String ROLE_SUPERVISOR = "SUP-ATENDIMENTO";
    private final String ROLE_ADMIN = "ADMIN";

    private final String PATH = "/reclamacao/**";

    private final JwtAuthenticationEntrypoint jwtAuthenticationEntrypoint;
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter, JwtAuthenticationEntrypoint jwtAuthenticationEntrypoint) {
        this.jwtFilter = jwtFilter;
        this.jwtAuthenticationEntrypoint = jwtAuthenticationEntrypoint;
    }


    @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()

            .exceptionHandling()
            .authenticationEntryPoint(jwtAuthenticationEntrypoint)
            .accessDeniedHandler(
                    new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        System.out.println("Access denied: " + accessDeniedException.getMessage());
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                })

            .and()
                .authorizeRequests()
                .antMatchers(PATH).hasAnyAuthority(ROLE_ATENDENTE, ROLE_ADMIN, ROLE_SUPERVISOR, ROLE_CLIENTE)
                .anyRequest().authenticated()
            .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new DebugFilter(), FilterSecurityInterceptor.class) // Adiciona o filtro de debug
                .formLogin().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;

        return http.build();
    }

    private static class DebugFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Authentication: " + authentication);
            chain.doFilter(request, response);
        }
    }


}
