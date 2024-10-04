package br.com.ingresse.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ingresse.entities.Session;

public interface ISessionRepository extends JpaRepository<Session, UUID> {
	Optional<Session> findByIsActive(boolean isActive);
}
