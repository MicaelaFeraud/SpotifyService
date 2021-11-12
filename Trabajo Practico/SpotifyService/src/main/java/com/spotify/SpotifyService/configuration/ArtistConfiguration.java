package com.spotify.SpotifyService.configuration;
import com.spotify.SpotifyService.Service.ArtistService;
import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/artist")
public class ArtistConfiguration {

    @Autowired
    private ArtistService artistService;

    @GetMapping(path = "/{id}")
    public Artist retriveTrack(@PathVariable("idArtist") Long idArtist){
        return artistService.getArtist(idArtist);
    }

    @GetMapping(path = "/")
    public Iterable<Artist> retriveTrack(){
        return artistService.getArtist();
    }

    @PostMapping(path = "/")
    public Artist createArtist(@Validated @RequestBody ArtistRequest request){
        return artistService.createArtist(request);
    }

    @PostMapping(path = "/{id}")
    public Artist deteleArtist(@Validated @RequestBody ArtistRequest request, @PathVariable("idArtist") Long idArtist){
        return artistService.editArtist(request, idArtist);
    }

    @DeleteMapping(path = "/{id}")
    public Artist deteleArtist(@PathVariable("idArtist") Long idArtist){
        return artistService.deteleArtist(idArtist);
    }
}
