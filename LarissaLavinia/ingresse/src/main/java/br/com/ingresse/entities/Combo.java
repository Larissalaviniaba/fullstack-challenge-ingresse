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
@NoArgsConstructor
@AllArgsConstructor
public class Combo {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Setter
	@Column(nullable = false)
	private String name;
	
	@Setter
	@Column(nullable = false)
	private Double price;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Setter
	@Column(name= "updated_at", nullable = false)
	private LocalDateTime updatedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItens = new ArrayList<>();
}
