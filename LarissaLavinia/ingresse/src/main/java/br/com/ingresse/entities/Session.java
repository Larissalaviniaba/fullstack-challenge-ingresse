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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name="available_total_seats", nullable = false)
	@Setter
	private Integer availableTotalSeats;
	
	@Column(name= "is_active", nullable = false)
	@Setter
	private boolean isActive;
	
	@Column(name= "start_time", nullable = false)
	@Setter
	private LocalDateTime startTime;
	
	@Column(name= "end_time", nullable = false)
	@Setter
	private LocalDateTime endTime;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Ticket> tickets = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name= "movie_id", nullable = false)
	private Movie movie;
}
