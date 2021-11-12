package com.spotify.SpotifyService.Service;
import com.spotify.SpotifyService.Service.impl.IAlbum;
import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.entidades.mapper.AlbumMapper;
import com.spotify.SpotifyService.entidades.model.Album;
import com.spotify.SpotifyService.exception.AlbumExistException;
import com.spotify.SpotifyService.exception.ArtistNotExistException;
import com.spotify.SpotifyService.repository.AlbumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Service
public class AlbumService implements IAlbum {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    private Map<Long, Album> albumMap = new HashMap<>();

    @PostConstruct
    public void init(){
        albumMap = new HashMap<>();
        albums.stream().forEach(album -> {
            albumRepository.save(album);
        });
    }

    public Album getAlbum(Long idAlbum) {
        return albumRepository.findByIdAlbum(idAlbum);
    }

    public Iterable<Album> getAlbum() {
        return albumRepository.findAll();
    }

    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (request.getIdAlbum() != null && albumRepository.
                findByIdAlbum(request.getIdAlbum()) != null){
            log.error("El album ya existe.");
            throw new AlbumExistException("El album ya existe.");
        }else {
            albumRepository.save(albumMapper.apply(request));
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long idAlbum) {
        Album album = null;
        if (albumRepository.findByIdAlbum(idAlbum) != null){
            album = albumMapper.apply(request);
            albumMap.remove(request.getIdAlbum());
            albumMap.put(request.getIdAlbum(), album);
        }else {
            log.error("El album NO existe.");
            throw new ArtistNotExistException("El Album NO existe.");
        }return album;
    }

    public Album deteleAlbum(Long idAlbum) {
        albumRepository.deleteById(idAlbum);
        return null;
    }
}