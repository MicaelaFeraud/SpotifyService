package com.spotify.SpotifyService.repository;

import org.springframework.data.repository.CrudRepository;
import com.spotify.SpotifyService.entidades.model.Track;

import java.util.List;

public interface TrackRepository extends CrudRepository<Track, Long>{

    List<Track>findByName(String name);

    Track findById(long id);
}
