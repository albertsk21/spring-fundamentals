package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dtos.SongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {
    private SongRepository songRepository;
    private UserRepository userRepository;
    private StyleRepository styleRepository;
    private ModelMapper modelMapper;
    public SongServiceImpl(SongRepository songRepository, UserRepository userRepository, StyleRepository styleRepository, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
        this.styleRepository = styleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveSong(SongDTO songDTO, UUID userId) {

        User user = this.userRepository.findUserById(userId);
        Style style = this.styleRepository.findStyleByStyleName(songDTO.getStyleNameEnum());

        Song song = new Song();

        song.setDate(songDTO.getDate());
        song.setDuration(songDTO.getDuration());
        song.setPerformer(songDTO.getPerformer());
        song.setTitle(songDTO.getTitle());
        song.setUser(user);
        song.setStyle(style);


        this.songRepository.save(song);
    }

    @Override
    public List<SongDTO> findSongsByStyleName(StyleNameEnum styleName) {
        return this.songRepository.findSongsByStyleName(styleName)
                .stream()
                .map(s ->  this.modelMapper.map(s, SongDTO.class))
                .collect(Collectors.toList());
    }


}
