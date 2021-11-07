package com.spotify.SpotifyService.controller;


import com.spotify.SpotifyService.Service.ArtistService;
import com.spotify.SpotifyService.entidades.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/artist")

public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public Artist retriveArtist(@PathVariable("id") Long idArtist){
        return artistService.getArtist(idArtist);
    }

    @GetMapping(path = "/")
    public Iterable<Artist> retriveArtist(){
        return artistService.getArtist();
    }
}
