package com.spotify.SpotifyService.Service;
import com.spotify.SpotifyService.Service.impl.IArtist;
import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.mapper.ArtistMapper;
import com.spotify.SpotifyService.entidades.model.Artist;
import com.spotify.SpotifyService.exception.ArtistExistException;
import com.spotify.SpotifyService.exception.ArtistNotExistException;
import com.spotify.SpotifyService.repository.ArtistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Service
public class ArtistService implements IArtist {
    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistRepository artistRepository;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    private Map<Long, Artist> artistMap = new HashMap<>();

    @PostConstruct
    public void init(){
        artistMap = new HashMap<>();
        artists.stream().forEach(artist -> {
            artistRepository.save(artist);
        });
    }

    public  Artist getArtist(Long idArtist){
        return artistRepository.findByIdArtist(idArtist);
    }

    public Iterable<Artist> getArtist() {
        return artistRepository.findAll();
    }

    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (request.getIdArtist() != null && artistRepository.
                findByIdArtist(request.getIdArtist()) != null){
            log.error("El artista ya existe.");
            throw new ArtistExistException("El Artista ya existe.");
        }else {
            artistRepository.save(artistMapper.apply(request));
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long idArtist) {
        Artist artist = null;
        if (artistRepository.findByIdArtist(idArtist) != null){
            artist = artistMapper.apply(request);
            artistMap.remove(request.getIdArtist());
            artistMap.put(request.getIdArtist(), artist);
        }else{
            log.error("El artista NO existe.");
            throw new ArtistNotExistException("El Artista no existe.");
        }return artist;
    }

    public Artist deteleArtist(Long idArtist) {
        artistRepository.deleteById(idArtist);
        return null;
    }
}
