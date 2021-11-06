package com.spotify.SpotifyService.Service;


import com.spotify.SpotifyService.Service.impl.IArtist;
import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.mapper.ArtistMapper;
import com.spotify.SpotifyService.entidades.model.Artist;
import com.spotify.SpotifyService.exception.ArtistExistException;
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
public class ArtistService implements IArtist {
    @Autowired
    private ArtistMapper artistMapper;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    @PostConstruct
    public void init(){
        artistMap = new HashMap<>();
        artists.stream().forEach(artist -> {
            artistMap.put(artist.getIdArtist(),artist);
        });
    }

    private Map<Long, Artist> artistMap;

    public  Artist getArtist(Long idArtist){
        return artistMap.get(idArtist);
    }

    public List<Artist> getArtist() {
        return new ArrayList<>(artistMap.values());
    }

    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistMap.get(request.getIdArtist()) == null){
            artistMap.put(request.getIdArtist(), artistMapper.apply(request));
        }else {
            log.error("El artista ya existe.");
            throw new ArtistExistException("El Artista ya existe.");
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long idArtist) {
        Artist artist = null;
        if (artistMap.get(idArtist) != null){
            artist = artistMapper.apply(request);
            artistMap.remove(request.getIdArtist());
            artistMap.put(request.getIdArtist(),artist);
        }else{
            log.error("El artista NO existe.");
            throw new ArtistNotExistException("El Artista no existe.");
        }return artist;
    }

    public Artist deteleArtist(Long idArtist) {
        return artistMap.remove(idArtist);
    }


}
