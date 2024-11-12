package br.com.ingresse.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ingresse.DTOs.ListMovieDTO;
import br.com.ingresse.entities.Movie;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApiMovieService {

	@Value("${api_url}")
	private final String API_URL;
	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;
	private final MovieService movieService;
	

	private List<Movie> getMoviesExternalAPi() throws IOException {
		try {
		    HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(API_URL))
		        .GET()
		        .build();

		    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		    if (response.statusCode() == 200) {
		        List<Movie> movies = objectMapper.readValue(response.body(), ListMovieDTO.class).getResults();
		        
		        return getFourMovies(movies);
		    } else {
		        throw new IOException("Erro ao buscar filmes: " + response.statusCode());
		    }
		    
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		    throw new IOException("Requisição interrompida: " + e.getMessage(), e);
		    
		} catch (IOException e) {
		    throw new IOException("Erro na requisição: " + e.getMessage(), e);
		}
	}
	
	@Scheduled(fixedRate = 24 * 60 * 60 * 1000)
	private void cleanAndSaveNewMovies() throws IOException {
		movieService.deleteMovies();
		
        try {
			movieService.saveMovies(getMoviesExternalAPi());
		} catch (IOException e) {
			throw new IOException("Erro na requisição: " + e.getMessage(), e);
		}
	}
	
	private List<Movie> getFourMovies(List<Movie> movies) {
		if (movies == null || movies.isEmpty()) {
	        return Collections.emptyList();
	    }
	    return movies.subList(0, 4);
	}

}
