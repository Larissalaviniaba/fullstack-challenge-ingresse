package br.com.ingresse.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	@Setter
	private Double price;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
	@ManyToOne
	@JoinColumn(name= "order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name= "combo_id", nullable = false)
	private Combo combo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "ticket_id", referencedColumnName = "id", nullable = false)
	private Ticket ticket;
}
