package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.StyleDTO;

import java.util.List;

public interface StyleService {

    boolean isEmpty();
    void saveStyle(StyleDTO styleDTO);
    List<StyleDTO> getAll();

}
