package com.example.heroes.service.impl;

import com.example.heroes.model.dtos.HeroDTO;
import com.example.heroes.model.entities.Hero;
import com.example.heroes.model.entities.User;
import com.example.heroes.repository.HeroRepository;
import com.example.heroes.repository.UserRepository;
import com.example.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private HeroRepository heroRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<HeroDTO> getAllByUserId(UUID uuid) {
        return this.heroRepository.findHeroByUserId(uuid)
                .stream()
                .map(hero -> this.modelMapper.map(hero,HeroDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(HeroDTO heroDTO, UUID userId) {

        User user = this.userRepository.findUserById(userId);
        if (user == null){
            return;
        }

        Hero hero = this.modelMapper.map(heroDTO, Hero.class);
        hero.setUser(user);
        this.heroRepository.save(hero);
    }

    @Override
    public void delete(UUID id) {
        this.heroRepository.deleteById(id);
    }

    @Override
    public HeroDTO getHero(UUID uuid) {
        return this.modelMapper.map(this.heroRepository.findHeroById(uuid),HeroDTO.class);
    }
}
