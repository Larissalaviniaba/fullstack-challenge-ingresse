package br.com.ingresse.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.ingresse.entities.Movie;
import br.com.ingresse.repositories.IMovieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

	private final IMovieRepository movieRepository;
	private final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

	public Movie findById(Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Filme não encontrado."));
		return movie;
	}

	public List<Movie> findAll() {
		List<Movie> movies = movieRepository.findAll();
		return movies;
	}

	public List<Movie> saveMovies(List<Movie> movies) {
		movies.forEach(movie -> {
			if (movie.getPosterPath() != null) {
				movie.setPosterPath(IMAGE_BASE_URL + movie.getPosterPath());
			}
		});

		List<Movie> moviesSaved = movieRepository.saveAll(movies);
		return moviesSaved;
	}

	public void deleteMovies() {
		movieRepository.deleteAll();
	}
}
