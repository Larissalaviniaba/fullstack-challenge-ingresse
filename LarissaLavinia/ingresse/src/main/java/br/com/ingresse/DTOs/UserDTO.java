package br.com.ingresse.DTOs;

import java.time.LocalDateTime;

public record UserDTO(String name, String email, String cpf, LocalDateTime birthDate) {
}
