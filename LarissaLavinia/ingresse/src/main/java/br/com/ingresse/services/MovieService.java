package br.com.ingresse.services;

import org.springframework.stereotype.Service;

import br.com.ingresse.repositories.IMovieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

	private final ApiMovieService apiMovieService;
	private final IMovieRepository movieRepository;
	
//	public Movie findById(Integer id) {
//
//	}
//
//	public List<Movie> findAll() {
//	}
//
//	public UserDTO createMovie(Movie movie) {
//		
//	}
//
//
//	public void deleteMovie(Integer id) {
//		
//	}
}
