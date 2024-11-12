package br.com.ingresse.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ingresse.entities.Movie;
import br.com.ingresse.services.MovieService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("movies")
public class MovieController {

	private final MovieService movieService;

	@GetMapping()
	public ResponseEntity<List<Movie>> listMoviesLocal() {
		List<Movie> movies = movieService.findAll();
		return ResponseEntity.ok(movies);
	}
}
