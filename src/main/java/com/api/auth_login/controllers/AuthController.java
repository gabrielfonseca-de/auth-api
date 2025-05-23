package com.api.auth_login.controllers;

import com.api.auth_login.dto.LoginRequestDTO;
import com.api.auth_login.dto.ResponseDTO;
import com.api.auth_login.dto.RegisterRequestDTO;
import com.api.auth_login.domain.user.User;
import com.api.auth_login.exception.CustomException;
import com.api.auth_login.infra.security.TokenService;
import com.api.auth_login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints de login e registro de usuários")
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Realiza autenticação e retorna um token JWT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login bem-sucedido"),
            @ApiResponse(responseCode = "401", description = "Senha incorreta"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        User user = repository.findByEmail(body.email())
                .orElseThrow(() -> new CustomException("Usuário não encontrado", HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            throw new CustomException("Senha incorreta", HttpStatus.UNAUTHORIZED);
        }

        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
    }

    @PostMapping("/register")
    @Operation(summary = "Registro de novo usuário", description = "Cria um novo usuário e retorna um token JWT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso"),
            @ApiResponse(responseCode = "409", description = "E-mail já cadastrado")
    })
    public ResponseEntity<ResponseDTO> register(@RequestBody @Valid RegisterRequestDTO body) {
        if (repository.findByEmail(body.email()).isPresent()) {
            throw new CustomException("E-mail já cadastrado", HttpStatus.CONFLICT);
        }

        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        repository.save(newUser);

        String token = tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
    }
}
