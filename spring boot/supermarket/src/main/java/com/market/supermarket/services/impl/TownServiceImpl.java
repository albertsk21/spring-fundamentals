package com.market.supermarket.services.impl;

import com.market.supermarket.model.dtos.TownDto;
import com.market.supermarket.model.entities.TownEntity;
import com.market.supermarket.repositories.TownRepository;
import com.market.supermarket.services.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;
    private ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveTown(TownDto townDto) {
        TownEntity town = this.modelMapper.map(townDto,TownEntity.class);
        this.townRepository.save(town);
    }
}
