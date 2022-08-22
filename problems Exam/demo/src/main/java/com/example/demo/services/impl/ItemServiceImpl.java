package com.example.demo.services.impl;


import com.example.demo.domain.dtos.ItemDTO;
import com.example.demo.domain.model.Category;
import com.example.demo.domain.model.Item;
import com.example.demo.domain.model.User;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public ItemServiceImpl(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(ItemDTO itemDTO, UUID userId) {


        User user = this.userRepository.findUserById(userId);
        Category category = this.categoryRepository.findCategoryByOption(itemDTO.getCategory());

        Item item = new Item();
        item.setDescription(itemDTO.getDescription());
        item.setGender(itemDTO.getGender());
        item.setPrice(itemDTO.getPrice());
        item.setName(itemDTO.getName());
        item.setCategory(category);
        item.setUser(user);

        this.itemRepository.save(item);

    }

    @Override
    public List<ItemDTO> getAll() {
        return this.itemRepository.findAll()
                .stream()
                .map(this::convertToItemDTO)
                .collect(Collectors.toList());


    }

    @Override
    public ItemDTO getById(UUID id) {
        return this.convertToItemDTO(this.itemRepository.findItemById(id));
    }

    @Override
    public void deleteItem(UUID itemId, UUID userId) {


        User user = this.userRepository.findUserById(userId);
        Item item = this.itemRepository.findItemById(itemId);

        if(user == null || item == null){
            return;
        }

        this.itemRepository.deleteById(itemId);

    }

    public ItemDTO convertToItemDTO(Item item){
        ItemDTO itemDTO= new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setCategory(item.getCategory().getOption());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setGender(item.getGender());
        itemDTO.setOwnerId(item.getUser().getId());

        return itemDTO;
    }
}
