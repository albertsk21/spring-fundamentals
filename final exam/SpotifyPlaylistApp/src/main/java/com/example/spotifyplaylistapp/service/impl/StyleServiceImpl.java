package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dtos.StyleDTO;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StyleServiceImpl implements StyleService {
    private StyleRepository styleRepository;
    private ModelMapper modelMapper;

    public StyleServiceImpl(StyleRepository styleRepository, ModelMapper modelMapper) {
        this.styleRepository = styleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isEmpty() {
        return this.styleRepository.count() <= 0;
    }

    @Override
    public void saveStyle(StyleDTO styleDTO) {
        this.styleRepository.save(this.modelMapper.map(styleDTO, Style.class));
    }

    @Override
    public List<StyleDTO> getAll() {
        return this.styleRepository.findAll()
                .stream()
                .map(s -> this.modelMapper.map(s, StyleDTO.class))
                .collect(Collectors.toList());
    }
}
