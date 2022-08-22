package com.example.battleships.services;

import com.example.battleships.models.dtos.ShipDTO;

import java.util.List;
import java.util.UUID;

public interface ShipService {

    List<ShipDTO> getAll();
    void save(ShipDTO shipDTO);
    List<ShipDTO> findByUserId(UUID uuid);
    List<ShipDTO> findWithoutUserId(UUID uuid);
    void attackShip(String attackerShipName, String defenderShipName);

}
