package br.com.ingresse.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ingresse.entities.User;
import br.com.ingresse.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findOne(@PathVariable UUID id){
		User user = userService.findById(id);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
