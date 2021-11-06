package com.spotify.SpotifyService.Service;

import com.spotify.SpotifyService.Service.impl.IAlbum;
import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.entidades.mapper.AlbumMapper;
import com.spotify.SpotifyService.entidades.model.Album;
import com.spotify.SpotifyService.exception.AlbumExistException;
import com.spotify.SpotifyService.exception.ArtistNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AlbumService implements IAlbum {

    @Autowired
    private AlbumMapper albumMapper;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    @PostConstruct
    public void init(){
        albumMap = new HashMap<>();
        albums.stream().forEach(album -> {
            albumMap.put(album.getIdAlbum(), album);
        });
    }

    private Map<Long, Album> albumMap;

    public Album getAlbum(Long idAlbum) {
        return albumMap.get(idAlbum);
    }

    public List<Album> getAlbum() {
        return new ArrayList<>(albumMap.values());
    }

    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumMap.get(request.getIdAlbum()) == null) {
            albumMap.put(request.getIdAlbum(), albumMapper.apply(request));
        }else {
            log.error("El album ya existe.");
            throw new AlbumExistException("El album ya existe.");
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long idAlbum) {
        Album album = null;
        if (albumMap.get(idAlbum) != null){
            album = albumMapper.apply(request);
            albumMap.remove(request.getIdAlbum());
            albumMap.put(request.getIdAlbum(), album);
        }else {
            log.error("El album NO existe.");
            throw new ArtistNotExistException("El Album NO existe.");
        }return album;
    }

    public Album deteleAlbum(Long idAlbum) {
        return albumMap.remove(idAlbum);
    }
}
