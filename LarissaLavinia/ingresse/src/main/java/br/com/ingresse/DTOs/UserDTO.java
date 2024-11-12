package br.com.ingresse.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private UUID id;
	private String cpf;
	private String name;
	private String email;
	private LocalDateTime birthDate;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
