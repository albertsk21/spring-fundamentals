package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.dtos.SongDTO;
import com.example.spotifyplaylistapp.model.dtos.UserDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private SongRepository songRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
    }

    @Override
    public UUID getIdByUsernameAndPassword(String username, String password) {
        return this.userRepository.findUserIdByUsernameAndPassword(username,password).orElse(null);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        this.userRepository.save(this.modelMapper.map(userDTO, User.class));
    }

    @Override
    public void addSongInPlaylist(UUID songId, UUID userId) {


        Song song = this.songRepository.findSongById(songId);
        User user = this.userRepository.findUserById(userId);

        for (Song checkSong :user.getPlaylist() ) {
            if(checkSong.getId().equals(songId)){
                return;
            }
        }
        user.getPlaylist().add(song);
        song.getUsers().add(user);
        this.userRepository.save(user);
    }

    @Override
    public List<SongDTO> gePlayListByUserId(UUID id) {

        User user = this.userRepository.findUserById(id);

        return user.getPlaylist()
                .stream()
                .map(s -> this.modelMapper.map(s, SongDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void clearPlaylistByUserId(UUID id) {
        User user = this.userRepository.findUserById(id);



    }


}
