package com.spotify.SpotifyService.entidades.mapper;

import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.model.Artist;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component

public class ArtistMapper implements Function<ArtistRequest, Artist> {

    @Override
    public Artist apply(ArtistRequest artistRequest){
        return Artist.builder()
                .idArtist(artistRequest.getIdArtist())
                .name(artistRequest.getName())
                .genere(artistRequest.getGenere())
                .image(artistRequest.getImage())
                .build();
    }
}
