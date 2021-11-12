package com.spotify.SpotifyService.repository;
import org.springframework.data.repository.CrudRepository;
import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long>{

    List<Track>findByName(String name);

    Track findById(long id);
}
