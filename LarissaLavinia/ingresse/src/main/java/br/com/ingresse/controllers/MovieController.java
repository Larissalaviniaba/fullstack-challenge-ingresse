package br.com.ingresse.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ingresse.entities.Movie;
import br.com.ingresse.services.ApiMovieService;
import br.com.ingresse.services.MovieService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {
	
	private final ApiMovieService apiMovieService;
	private final MovieService movieService;

	@GetMapping
    public ResponseEntity<List<Movie>> listMoviesApi() {
        try {
        	List<Movie> movies = apiMovieService.getMovies();
            return ResponseEntity.ok(movies);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }
	
	@GetMapping("/local")
    public ResponseEntity<List<Movie>> listMoviesLocal() {
        	List<Movie> movies = movieService.findAll();
            return ResponseEntity.ok(movies);
    }
}
