package com.market.supermarket.services;

import com.market.supermarket.model.dtos.TownDto;

import java.io.IOException;

public interface TownService {

    void saveTown(TownDto townDto) throws IOException;

}
