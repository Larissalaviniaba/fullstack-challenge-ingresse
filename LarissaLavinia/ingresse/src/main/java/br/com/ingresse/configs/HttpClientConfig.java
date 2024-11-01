package br.com.ingresse.configs;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig { // Renamed class to avoid confusion
    @Bean
    HttpClient createHttpClient() { // Renamed method to avoid circular reference
        return HttpClient.newHttpClient(); // Example configuration
    }
}
