package br.com.ingresse.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ingresse.DTOs.UserCreateDTO;
import br.com.ingresse.DTOs.UserDTO;
import br.com.ingresse.entities.User;
import br.com.ingresse.jpaSpecifications.UserSpecification;
import br.com.ingresse.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

	private final ModelMapper mapper;
	private final UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findOne(@PathVariable UUID id) {
		UserDTO user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
		UserDTO user = userService.findByCpf(cpf);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
		UserDTO user = userService.findByEmail(email);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(@RequestParam(required = false) String name,
			@RequestParam(required = false) LocalDateTime startDateCreated,
			@RequestParam(required = false) LocalDateTime endDateCreated) {

		Specification<User> userSpecification = Specification.where(UserSpecification.nameContain(name)
				.and(UserSpecification.createDateBetween(startDateCreated, endDateCreated)));
		List<UserDTO> users = userService.findAll(userSpecification);
		return ResponseEntity.ok(users);
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
		User user = mapper.map(userCreateDTO, User.class);
		UserDTO savedUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable UUID id, @RequestBody UserCreateDTO userCreateDTO) {
		User user = mapper.map(userCreateDTO, User.class);
		UserDTO updatedUser = userService.updateUser(id, user);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
