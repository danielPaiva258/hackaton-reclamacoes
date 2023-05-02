package br.com.fiap.hackaton.controller;

import br.com.fiap.hackaton.dto.AuthDTO;
import br.com.fiap.hackaton.dto.JwtDTO;
import br.com.fiap.hackaton.dto.UserCreateDTO;
import br.com.fiap.hackaton.dto.UserDTO;
import br.com.fiap.hackaton.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class LoginController {
    private final UserServiceImpl userService;
    public LoginController(UserServiceImpl userService){
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
