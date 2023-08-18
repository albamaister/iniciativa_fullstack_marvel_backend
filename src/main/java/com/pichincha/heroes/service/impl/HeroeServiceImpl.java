package com.pichincha.heroes.service.impl;

import com.pichincha.heroes.configuration.HeroesProperties;
import com.pichincha.heroes.service.HeroeMarvelService;
import com.pichincha.heroes.service.HeroeService;
import com.pichincha.heroes.service.dto.Heroe;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class HeroeServiceImpl implements HeroeService {
    HeroesProperties heroesProperties;
    HeroeMarvelService heroeMarvelService;
    @Override
    public List<Heroe.Results> getHeroes() {
        Long timestamp = new Date().getTime();
            String valueHash = timestamp.toString()+heroesProperties.getPrivateKey()+heroesProperties.getPublicKey();
            String hash = DigestUtils.md5DigestAsHex(valueHash.getBytes(StandardCharsets.UTF_8));
            Heroe heroe = heroeMarvelService.getHeroes(heroesProperties.getPublicKey(),timestamp,hash).getBody();
            log.info(heroe);
        return heroe.getData().getResults();
    }

    @Override
    public List<Heroe.Results> getHeroe(String id) {
        Long timestamp = new Date().getTime();
        String valueHash = timestamp.toString()+heroesProperties.getPrivateKey()+heroesProperties.getPublicKey();
        String hash = DigestUtils.md5DigestAsHex(valueHash.getBytes(StandardCharsets.UTF_8));
        Heroe heroe = heroeMarvelService.getHeroe( id ,heroesProperties.getPublicKey(),timestamp,hash).getBody();
        log.info(heroe);
        return heroe.getData().getResults();
    }
}
