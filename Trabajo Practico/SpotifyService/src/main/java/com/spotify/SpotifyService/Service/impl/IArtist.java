package com.spotify.SpotifyService.Service.impl;


import com.spotify.SpotifyService.controller.request.ArtistRequest;
import com.spotify.SpotifyService.entidades.model.Artist;

import java.util.List;

public interface IArtist {
    Artist getArtist(Long idArtist);
    List<Artist> getArtist();
    Artist createArtist(ArtistRequest request);
    Artist editArtist(ArtistRequest request, Long idArtist);
    Artist deteleArtist(Long idArtist);

}
