package br.com.ingresse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ingresse.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer>{
	
}
