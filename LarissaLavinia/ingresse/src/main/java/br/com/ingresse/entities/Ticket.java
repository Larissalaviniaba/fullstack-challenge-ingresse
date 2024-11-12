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
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Setter
	@Column(nullable = false)
	private String name;
	
	@Setter
	@Column(nullable = false)
	private String cpf;
	
	@Setter
	@Column(name="seat_number", nullable = false)
	private Integer seatNumber;
	
	@Setter
	@Enumerated(EnumType.STRING)
	@Column(length = 100, nullable = false)
	private Status status;
	
	@Setter
	@Column(nullable = false)
	private Double price;
	
	@Setter
	@Column(name= "reservation_time", nullable = false)
	private LocalDateTime reservationTime;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Setter
	@Column(name= "updated_at", nullable = false)
	private LocalDateTime updatedDate;
	
	@OneToOne(mappedBy = "ticket")
	private OrderItem orderItem;
	
	@ManyToOne()
	@JoinColumn(name= "session_id", nullable = false)
	private Session session;
}
