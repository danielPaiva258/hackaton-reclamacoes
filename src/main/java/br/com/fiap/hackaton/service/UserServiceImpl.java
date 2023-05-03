package br.com.fiap.hackaton.service;

import br.com.fiap.hackaton.dto.AuthDTO;
import br.com.fiap.hackaton.dto.JwtDTO;
import br.com.fiap.hackaton.dto.UserCreateDTO;
import br.com.fiap.hackaton.dto.UserDTO;
import br.com.fiap.hackaton.models.Usuario;
import br.com.fiap.hackaton.repository.UserRepository;
import br.com.fiap.hackaton.security.JwtTokenUtil;
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
        Usuario usr = userRepository.findFirstByUsername(authDTO.getUsername())
                .orElseThrow();

        String token = jwtTokenUtil.generateToken(usr);
        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(token);
        return jwtDTO;
    }
}
