package br.com.ingresse.configs;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {
    @Bean
    HttpClient createHttpClient() {
        return HttpClient.newHttpClient();
    }
}
