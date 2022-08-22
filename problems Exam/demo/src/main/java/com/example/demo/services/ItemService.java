package com.example.demo.services;

import com.example.demo.domain.dtos.ItemDTO;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    void save(ItemDTO itemDTO, UUID userId);
    List<ItemDTO> getAll();
    ItemDTO getById(UUID id);
    void deleteItem(UUID itemId, UUID userId);
}
