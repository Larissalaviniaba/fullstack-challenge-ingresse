package br.com.ingresse.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {

	@Bean
	ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}
}
