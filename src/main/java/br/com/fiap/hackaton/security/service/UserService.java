package br.com.fiap.hackaton.security.service;

import br.com.fiap.hackaton.security.dto.AuthDTO;
import br.com.fiap.hackaton.security.dto.JwtDTO;
import br.com.fiap.hackaton.security.dto.UserCreateDTO;
import br.com.fiap.hackaton.security.dto.UserDTO;

public interface UserService {
    UserDTO create(UserCreateDTO userCreateDTO);
    JwtDTO login(AuthDTO authDTO);
}
