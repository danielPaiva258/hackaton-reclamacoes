package br.com.fiap.hackaton.security.controller;

import br.com.fiap.hackaton.security.dto.AuthDTO;
import br.com.fiap.hackaton.security.dto.JwtDTO;
import br.com.fiap.hackaton.security.dto.UserCreateDTO;
import br.com.fiap.hackaton.security.dto.UserDTO;
import br.com.fiap.hackaton.security.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserServiceImpl userService;
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO){
        return userService.create(userCreateDTO);
    }
    @PostMapping("login")
    public JwtDTO login(@RequestBody AuthDTO authDTO){
        return userService.login(authDTO);
    }
}
