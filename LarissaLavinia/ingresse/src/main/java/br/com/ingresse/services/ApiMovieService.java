package br.com.ingresse.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ingresse.DTOs.ListMovieDTO;
import br.com.ingresse.entities.Movie;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApiMovieService {

	private final MovieService movieService;
	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;
//	@Value("${api_url}")
	private final String API_URL = "https://api.themoviedb.org/3/discover/movie?api_key=a1f1ad3a8c7064198c76cd82fab9b5fc&adult=false";

	public List<Movie> getMovies() throws IOException {
		try {
		    HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(API_URL))
		        .GET()
		        .build();

		    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		    if (response.statusCode() == 200) {
		        List<Movie> movies = objectMapper.readValue(response.body(), ListMovieDTO.class).getResults();
		        
		        movieService.createMovies(getFourMovies(movies));
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
	
	private List<Movie> getFourMovies(List<Movie> movies) {
		
		if (movies == null || movies.isEmpty()) {
	        return Collections.emptyList();
	    }
	    return movies.subList(0, 4);
	}

}
