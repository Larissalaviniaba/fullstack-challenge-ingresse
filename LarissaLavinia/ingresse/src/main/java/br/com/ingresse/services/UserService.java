package br.com.ingresse.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.ingresse.DTOs.UserDTO;
import br.com.ingresse.entities.User;
import br.com.ingresse.repositories.IUserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final IUserRepository userRepository;
	private final ModelMapper mapper;
	
	public UserDTO findById(UUID id) {
	    User user = this.userRepository.findById(id)
	        .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));
	    return mapper.map(user, UserDTO.class);
	}

	public UserDTO findByCpf(String cpf) {
		User user = this.userRepository.findByCpf(cpf)
				.orElseThrow(()-> new NoSuchElementException("Usuário não encontrado!"));
		return mapper.map(user, UserDTO.class);
	}

	public UserDTO findByEmail(String email) {
		Optional<User> user = this.userRepository.findByEmail(email);
		if (user.isEmpty()) {
			throw new NoSuchElementException("Usuário não encontrado!");
		}
		return mapper.map(user, UserDTO.class);
	}

	public List<UserDTO> findAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	public UserDTO createUser(User user) {
		User userCreated = this.userRepository.save(user);
		return mapper.map(userCreated, UserDTO.class);
	}

	public UserDTO updateUser(UUID id, User updateUser) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));
		if (updateUser.getName() != null)
			user.setName(updateUser.getName());
		if (updateUser.getEmail() != null)
			user.setEmail(updateUser.getEmail());
		if (updateUser.getPassword() != null)
			user.setPassword(updateUser.getPassword());
		if (updateUser.getCpf() != null)
			user.setCpf(updateUser.getCpf());
		if (updateUser.getBirthDate() != null)
			user.setBirthDate(updateUser.getBirthDate());

		User userUpdeted = this.userRepository.save(user);

		return mapper.map(userUpdeted, UserDTO.class);
	}

	public void deleteUser(UUID id) {
		if (!this.userRepository.existsById(id)) {
			throw new NoSuchElementException("Usuário não encontrado!");
		}
		this.userRepository.deleteById(id);
	}

}
