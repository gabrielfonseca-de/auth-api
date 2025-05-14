package com.api.auth_login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//implentando uma regra de negocio

public record RegisterRequestDTO (
        @NotBlank(message = "Nome não pode ser vazio")
        String name,

        @Email(message = "E-mail inválido")
        @NotBlank(message = "E-mail não pode ser vazio")
        String email,

        @NotBlank(message = "Senha não pode ser vazia")
        @Pattern(
                regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{10,}$",
                message = "A senha deve ter no mínimo 10 caracteres, incluindo letras, números e caracteres especiais."
        )
        String password

)
{
}
