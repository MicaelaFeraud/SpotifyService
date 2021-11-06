package com.spotify.SpotifyService.entidades.mapper;

import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.entidades.model.Album;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component

public class AlbumMapper implements Function<AlbumRequest, Album> {

    @Override
    public Album apply(AlbumRequest albumRequest){
        return Album.builder()
                .idAlbum(albumRequest.getIdAlbum())
                .name(albumRequest.getName())
                .build();
    }
}
