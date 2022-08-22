package com.example.heroes.service;

import com.example.heroes.model.dtos.HeroDTO;

import java.util.List;
import java.util.UUID;

public interface HeroService {
    List<HeroDTO> getAllByUserId(UUID uuid);
    void save(HeroDTO heroDTO, UUID userId);
    void delete(UUID id);
    HeroDTO getHero(UUID uuid);
}
