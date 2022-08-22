package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.SongDTO;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;

import java.util.List;
import java.util.UUID;

public interface SongService {


    void saveSong(SongDTO songDTO, UUID userId);

    List<SongDTO> findSongsByStyleName(StyleNameEnum styleName);
}
