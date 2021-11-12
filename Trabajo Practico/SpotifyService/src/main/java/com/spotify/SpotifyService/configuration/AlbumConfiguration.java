package com.spotify.SpotifyService.configuration;

import com.spotify.SpotifyService.Service.AlbumService;
import com.spotify.SpotifyService.Service.TrackService;
import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.model.Album;
import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/album")
public class AlbumConfiguration {

    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/{id}")
    public Album retriveAlbum(@PathVariable("idAlbum") Long idAlbum){
        return albumService.getAlbum(idAlbum);
    }

    @GetMapping(path = "/")
    public Iterable<Album> retriveAlbum(){
        return albumService.getAlbum();
    }

    @PostMapping(path = "/")
    public Album createAlbum(@Validated @RequestBody AlbumRequest request){
        return albumService.createAlbum(request);
    }

    @PostMapping(path = "/{id}")
    public Album deteleAlbum(@Validated @RequestBody AlbumRequest request, @PathVariable("idAlbum") Long idAlbum){
        return albumService.editAlbum(request, idAlbum);
    }

    @DeleteMapping(path = "/{id}")
    public Album deteleAlbum(@PathVariable("idAlbum") Long idAlbum){
        return albumService.deteleAlbum(idAlbum);
    }
}

