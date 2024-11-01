package br.com.ingresse.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnoreProperties
	private int id;
	
	@Column(nullable = false)
	@Setter
	private String title;
	
	@Column(nullable = false)
	@Setter
	private String overview;
	
	@Column(nullable = false)
	@Setter
	private String genero;
	
	@JsonProperty("poster_path")
	@Column(name= "poster_path", nullable = false)
	@Setter
	private String posterPath;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
}
