package br.com.ingresse.DTOs;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserCreateDTO {

	private String name;
	private String email;
	private String cpf;
	private String password;
	private LocalDateTime birthDate;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
