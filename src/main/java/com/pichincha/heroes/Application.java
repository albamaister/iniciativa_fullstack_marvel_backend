package com.pichincha.heroes;

import com.pichincha.heroes.configuration.HeroesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

@SpringBootApplication
@EnableConfigurationProperties({HeroesProperties.class})
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Configurar el filtro CORS
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Origen permitido
        config.addAllowedHeader("*"); // Todas las cabeceras permitidas
        config.addAllowedMethod("*"); // Todos los métodos HTTP permitidos
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
