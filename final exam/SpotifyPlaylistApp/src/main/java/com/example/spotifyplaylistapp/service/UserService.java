package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.SongDTO;
import com.example.spotifyplaylistapp.model.dtos.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UUID getIdByUsernameAndPassword(String username, String password);
    void saveUser(UserDTO userDTO);
    void addSongInPlaylist(UUID songId, UUID userId);
    List<SongDTO> gePlayListByUserId(UUID id);
    void clearPlaylistByUserId(UUID id);
}
