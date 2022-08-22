package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {

    @Query("FROM Song u " +
            "JOIN u.style AS s " +
            "WHERE s.styleName = ?1")
    List<Song> findSongsByStyleName(StyleNameEnum styleName);

    Song findSongById(UUID id);
}
