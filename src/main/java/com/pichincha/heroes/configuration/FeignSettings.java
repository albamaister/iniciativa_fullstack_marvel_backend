package com.pichincha.heroes.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSettings {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
