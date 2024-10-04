package br.com.ingresse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ingresse.entities.Combo;

public interface IComboRepository extends JpaRepository<Combo, UUID>{

}
