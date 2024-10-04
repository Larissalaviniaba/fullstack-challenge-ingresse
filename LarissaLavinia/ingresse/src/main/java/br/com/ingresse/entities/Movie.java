package br.com.ingresse.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	@Setter
	private String title;
	
	@Column(nullable = false)
	@Setter
	private String overview;
	
	@Column(nullable = false)
	@Setter
	private String genero;
	
	@Column(name= "poster_url", nullable = false)
	@Setter
	private String posterUrl;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Session> sessions = new ArrayList<>();
}
