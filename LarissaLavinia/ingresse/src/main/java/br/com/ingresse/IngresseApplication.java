package br.com.ingresse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IngresseApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngresseApplication.class, args);
	}

}
