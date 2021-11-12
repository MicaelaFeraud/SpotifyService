package com.spotify.SpotifyService.repository;
import com.spotify.SpotifyService.entidades.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist>findByNameArtist(String name);

    Artist findByIdArtist(long idArtist);
}
