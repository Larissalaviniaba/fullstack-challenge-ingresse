package br.com.ingresse.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.com.ingresse.DTOs.UserDTO;
import br.com.ingresse.entities.User;
import br.com.ingresse.repositories.IUserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private IUserRepository userRepository;

	@Mock
	private ModelMapper mapper;

	private User user;
	private UserDTO userDTO;
	private UUID id;

	@BeforeEach
	void setUp() {
		id = UUID.randomUUID();
		user = new User(
				id, 
				"Larissa Silva", 
				"larissa@example.com", 
				"senha123", 
				"12345678901",
				LocalDateTime.of(1999, 10, 15, 0, 0), 
				LocalDateTime.now(), 
				LocalDateTime.now(), 
				new ArrayList<>());
		
		userDTO = new UserDTO(
				id, 
				"Larissa Silva", 
				"larissa@example.com",
				"12345678901",
				LocalDateTime.of(1999, 10, 15, 0, 0), 
				LocalDateTime.now(), 
				LocalDateTime.now());
	}
	
	

	@Test
	void Should_ReturnUserSuccess_When_CalledFindById() {
		
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
		when(mapper.map(user, UserDTO.class)).thenReturn(userDTO);

		UserDTO result = userService.findById(id);

		assertThat(result).usingRecursiveComparison().isEqualTo(userDTO);

	}
	
	@Test
	void Should_ReturnUserSuccess_When_CalledFindByCpf() {
		when(userRepository.findByCpf("12345678901")).thenReturn(Optional.of(user));
		when(mapper.map(user, UserDTO.class)).thenReturn(userDTO);

		UserDTO result = userService.findByCpf("12345678901");

		assertThat(result).usingRecursiveComparison().isEqualTo(userDTO);
	}
	
	@Test
	void Should_ReturnUserSuccess_When_CalledFindByEmail() {
		when(userRepository.findByEmail("larissa@example.com")).thenReturn(Optional.of(user));
		when(mapper.map(user, UserDTO.class)).thenReturn(userDTO);

		UserDTO result = userService.findByEmail("larissa@example.com");

		assertThat(result).usingRecursiveComparison().isEqualTo(userDTO);
	}
	
	@Test
	void Should_ReturnCreatedUserSuccess_When_CalledCreateUser() {
		when(userRepository.save(user)).thenReturn(user);
		when(mapper.map(user, UserDTO.class)).thenReturn(userDTO);

		UserDTO result = userService.createUser(user);

		assertThat(result).usingRecursiveComparison().isEqualTo(userDTO);
	}
	
	@Test
	void Should_ReturnDeletedUserSuccess_When_CalledDeleteUser() {
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
	    userService.deleteUser(id);
	    verify(userRepository, times(1)).delete(user);
	}
}
