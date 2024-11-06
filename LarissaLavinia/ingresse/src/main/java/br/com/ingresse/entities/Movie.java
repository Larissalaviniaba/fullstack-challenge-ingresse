package br.com.ingresse.entities;

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
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties
	private Long id;
	
	@Column(nullable = false, length = 500)
	private String title;
	
	@Column(nullable = false, length = 2000)
	private String overview;
	
//	@Column(nullable = false)
//	private String genero;
	
	@JsonProperty("poster_path")
	@Column(name= "poster_path", nullable = false, length = 500)
	private String posterPath;
	
//	@Column(name= "created_at", nullable = false)
//	private LocalDateTime createdDate;
//	
//	@Column(name= "updated_at", nullable = false)
//	private LocalDateTime updatedDate;
	
}
