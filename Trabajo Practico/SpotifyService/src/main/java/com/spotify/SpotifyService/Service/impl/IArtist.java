package com.spotify.SpotifyService.Service.impl;
import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.model.Artist;

public interface IArtist {
    Artist getArtist(Long idArtist);
    Iterable<Artist> getArtist();
    Artist createArtist(ArtistRequest request);
    Artist editArtist(ArtistRequest request, Long idArtist);
    Artist deteleArtist(Long idArtist);

}
