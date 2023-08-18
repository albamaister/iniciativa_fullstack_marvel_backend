package com.pichincha.heroes.controller;

import com.pichincha.heroes.service.HeroeService;
import com.pichincha.heroes.service.dto.Heroe;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@lombok.extern.log4j.Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
public class HeroeController {

    HeroeService heroeService;
    @GetMapping(value = "${heroes.get.heroes}",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Heroe.Results>> getHeroes() {
        log.info("Start method getHeroes");
        List<Heroe.Results> response = heroeService.getHeroes();
        log.info("End method schedule :: Result [{}]", () -> response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "${heroes.get.heroe}",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Heroe.Results>> getHeroe(@PathVariable String id) {
        log.info("Start method getHeroe");
        List<Heroe.Results> response = heroeService.getHeroe(id);
        log.info("End method schedule :: Result [{}]", () -> response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
