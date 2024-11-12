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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	
	@Setter
	@Column(length = 100, nullable = false)
	private String name;
	
	@Setter
	@Column(length = 100, nullable = false)
	private String email;
	
	@Setter
	@JsonIgnore
	@Column(length = 255, nullable = false)
	private String password;
	
	@Column(length = 11, nullable = false)
	@Setter
	private String cpf;
	
	@Setter
	@Column(name= "birth_date", nullable = false)
	private LocalDateTime birthDate;
	
	@Column(name= "created_at", nullable = false)
	private LocalDateTime createdDate;
	
	@Setter
	@Column(name= "updated_at", nullable = false)
	private LocalDateTime updatedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();
	
	@PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now(); 
        this.updatedDate = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

}

