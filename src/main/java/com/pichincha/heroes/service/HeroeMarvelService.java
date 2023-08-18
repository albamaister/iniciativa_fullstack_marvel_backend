package com.pichincha.heroes.service;

import com.pichincha.heroes.configuration.FeignClientDefaultSettings;
import com.pichincha.heroes.service.dto.Heroe;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "marvel-client",
        url = "${heroesmarvel.url}",
        configuration = FeignClientDefaultSettings.class)
public interface HeroeMarvelService {
    @GetMapping("${heroesmarvel.get.characters}")
    ResponseEntity<Heroe> getHeroes(
            @PathVariable String apiKey, @PathVariable Long ts, @PathVariable String hash);
    @GetMapping("${heroesmarvel.get.character}")
    ResponseEntity<Heroe> getHeroe(
            @PathVariable String id, @PathVariable String apiKey, @PathVariable Long ts, @PathVariable String hash);
}
