package br.com.fiap.hackaton.service;

import br.com.fiap.hackaton.dto.AuthDTO;
import br.com.fiap.hackaton.dto.JwtDTO;
import br.com.fiap.hackaton.dto.UserCreateDTO;
import br.com.fiap.hackaton.dto.UserDTO;

public interface UserService {
    UserDTO create(UserCreateDTO userCreateDTO);
    JwtDTO login(AuthDTO authDTO);
}