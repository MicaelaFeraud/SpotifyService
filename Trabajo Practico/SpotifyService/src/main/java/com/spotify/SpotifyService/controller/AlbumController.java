package com.spotify.SpotifyService.controller;

import com.spotify.SpotifyService.Service.AlbumService;
import com.spotify.SpotifyService.entidades.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/album")

public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/{id}")
    public Album retriveAlbum(@PathVariable("id") Long idAlbum){
        return albumService.getAlbum(idAlbum);
    }

    @GetMapping(path = "/")
    public Iterable<Album> retriveAlbums(){
        return albumService.getAlbum();
    }
}
