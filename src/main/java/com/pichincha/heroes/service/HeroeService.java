package com.pichincha.heroes.service;

import com.pichincha.heroes.service.dto.Heroe;

import java.util.List;

public interface HeroeService {
    List<Heroe.Results> getHeroes();
    List<Heroe.Results> getHeroe(String id);
}
