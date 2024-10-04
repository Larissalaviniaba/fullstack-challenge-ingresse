package br.com.ingresse.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.ingresse.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	@Setter
	private String name;
	
	@Column(nullable = false)
	@Setter
	private String cpf;
	
	@Column(name="seat_number", nullable = false)
	@Setter
	private Integer seatNumber;
	
	@Column(length = 100, nullable = false)
	@Enumerated(EnumType.STRING)
	@Setter
	private Status status;
	
	@Column(nullable = false)
	@Setter
	private Double price;
	
	@Column(name= "reservation_time", nullable = false)
	@Setter
	private LocalDateTime reservationTime;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
	@OneToOne(mappedBy = "ticket")
	private OrderItem orderItem;
	
	@ManyToOne()
	@JoinColumn(name= "session_id", nullable = false)
	private Session session;
}
