package com.pichincha.heroes.configuration;

import lombok.AccessLevel;
import org.springframework.boot.context.properties.ConfigurationProperties;

@lombok.Getter
@lombok.Setter
@lombok.experimental.FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "heroesmarvel", ignoreUnknownFields = false)
public class HeroesProperties {
    String url;
    MethodGet get;
    String privateKey;
    String publicKey;
    @lombok.Getter
    @lombok.Setter
    @lombok.experimental.FieldDefaults(level = AccessLevel.PRIVATE)
    public static class MethodGet {
        String characters;
        String character;
    }

}
