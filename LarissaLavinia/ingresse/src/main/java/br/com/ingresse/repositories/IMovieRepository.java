package br.com.ingresse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ingresse.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, UUID>{

}
