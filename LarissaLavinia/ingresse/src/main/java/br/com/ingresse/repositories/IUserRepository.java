package br.com.ingresse.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.ingresse.entities.User;

public interface IUserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User>{
	Optional<User> findByEmail(String email);
	Optional<User> findByCpf(String cpf);
}
