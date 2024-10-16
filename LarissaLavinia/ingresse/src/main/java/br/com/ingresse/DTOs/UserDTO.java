package br.com.ingresse.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	private UUID id;
	private String name;
	private String email;
	private String cpf;
	private LocalDateTime birthDate;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}

