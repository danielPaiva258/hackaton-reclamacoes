package br.com.fiap.hackaton.security;

import br.com.fiap.hackaton.security.models.PerfilAcesso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    private final JwtAuthenticationEntrypoint jwtAuthenticationEntrypoint;
    private final JwtUserDetailService jwtUserDetailService;
    private final JwtFilter jwtFilter;
    private final PasswordEncoder passwordEncoder;
    public SecurityConfig(JwtAuthenticationEntrypoint
                                  jwtAuthenticationEntrypoint,
                          JwtUserDetailService jwtUserDetailService,
                          JwtFilter jwtFilter,
                          PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationEntrypoint = jwtAuthenticationEntrypoint;
        this.jwtUserDetailService = jwtUserDetailService;
        this.jwtFilter = jwtFilter;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.userDetailsService(jwtUserDetailService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()

                .and()
                    .authorizeRequests()
                    .antMatchers("/users/**").permitAll()
                    .antMatchers("/users").hasRole(PerfilAcesso.ACESSO_ADMINISTRADOR)
                    .antMatchers("/reclamacao/list").hasRole(PerfilAcesso.ACESSO_ATENDENTE)
                    .antMatchers("/pedido/**").hasRole(PerfilAcesso.ACESSO_ATENDENTE)
                    .anyRequest().authenticated()

                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntrypoint)
                    .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        System.out.println("Access denied: " + accessDeniedException.getMessage());
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    }
                })


                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(new DebugFilter(), FilterSecurityInterceptor.class) // Adiciona o filtro de debug
                    .csrf().disable()
                    .formLogin().disable();
    }
    private static class DebugFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Authentication: " + authentication);
            chain.doFilter(request, response);
        }
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager()
            throws Exception {
        return super.authenticationManager();
    }
}
