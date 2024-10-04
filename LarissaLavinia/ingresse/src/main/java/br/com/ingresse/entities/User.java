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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(updatable = false, nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
	private UUID id;
	
	@Column(length = 100, nullable = false)
	@Setter
	private String name;
	
	@Column(length = 100, nullable = false)
	@Setter
	private String email;
	
	@Column(length = 255, nullable = false)
	@Setter
	@JsonIgnore
	private String password;
	
	@Column(length = 11, nullable = false)
	@Setter
	private String cpf;
	
	@Column(name= "birth_date", nullable = false)
	@Setter
	private LocalDateTime birthDate;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name= "updated_at", nullable = false)
	@Setter
	private LocalDateTime updatedDate;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

}

