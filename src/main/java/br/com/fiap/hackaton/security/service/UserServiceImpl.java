package br.com.fiap.hackaton.security.service;

import br.com.fiap.hackaton.security.JwtTokenUtil;
import br.com.fiap.hackaton.security.dto.AuthDTO;
import br.com.fiap.hackaton.security.dto.JwtDTO;
import br.com.fiap.hackaton.security.dto.UserCreateDTO;
import br.com.fiap.hackaton.security.dto.UserDTO;
import br.com.fiap.hackaton.security.models.Usuario;
import br.com.fiap.hackaton.security.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(JwtTokenUtil jwtTokenUtil,
                           AuthenticationManager authenticationManager,
                           PasswordEncoder passwordEncoder,
                           UserRepository userRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(UserCreateDTO userCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(userCreateDTO.getUsername());
        usuario.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        Usuario savedUsuario = userRepository.save(usuario);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUsuario.getId());
        userDTO.setUsername(savedUsuario.getUsername());
        return userDTO;
    }

    @Override
    public JwtDTO login(AuthDTO authDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authDTO.getUsername(), authDTO.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    e.getMessage());
        }
        String token = jwtTokenUtil.generateToken(authDTO.getUsername());
        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(token);
        return jwtDTO;
    }
}
