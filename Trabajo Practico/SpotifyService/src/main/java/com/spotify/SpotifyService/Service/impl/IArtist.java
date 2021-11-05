package com.spotify.SpotifyService.Service.impl;


import com.spotify.SpotifyService.entidades.model.Artist;

import java.util.List;

public interface IArtist {
    Artist getArtist(Long id);
    List<Artist> getArtist();
    Artist createArtist(ArtistRequest request);

}
