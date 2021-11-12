package com.spotify.SpotifyService.repository;
import com.spotify.SpotifyService.entidades.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album>findByNameAlbum(String name);

    Album findByIdAlbum(long idAlbum);
}
