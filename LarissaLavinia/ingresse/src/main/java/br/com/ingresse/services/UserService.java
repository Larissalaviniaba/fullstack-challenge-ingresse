package br.com.ingresse.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ingresse.entities.User;
import br.com.ingresse.repositories.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository userRepository;

	public User findById(UUID id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user.isEmpty()) {
			throw new NullPointerException("Usuário não encontrado!");
		}
		return user.get();
	}

	public User findBycpf(String cpf) {
		Optional<User> user = this.userRepository.findByCpf(cpf);
		if (user.isEmpty()) {
			throw new NullPointerException("Usuário não encontrado!");
		}
		return user.get();
	}

	public User findByEmail(String email) {
		Optional<User> user = this.userRepository.findByEmail(email);
		if (user.isEmpty()) {
			throw new NullPointerException("Usuário não encontrado!");
		}
		return user.get();
	}
	
	public List<User> findAll(){
		List<User> users = this.userRepository.findAll();
		return users;
	}

	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	public User updateUser(UUID id, User updateUser) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));
		if(updateUser.getName() != null) user.setName(user.getName());
		if(updateUser.getEmail() != null) user.setEmail(user.getEmail());
		if(updateUser.getPassword() != null) user.setPassword(user.getPassword());
		if(updateUser.getCpf() != null) user.setCpf(user.getCpf());
		if(updateUser.getBirthDate() != null) user.setBirthDate(user.getBirthDate());
		user.setUpdatedDate(LocalDateTime.now());
		
		return this.userRepository.save(user);
	}

	public void deleteUser(UUID id) {
		if(!this.userRepository.existsById(id)) {
			throw new NoSuchElementException("Usuário não encontrado!");
		}
		this.userRepository.deleteById(id);
	}

}
