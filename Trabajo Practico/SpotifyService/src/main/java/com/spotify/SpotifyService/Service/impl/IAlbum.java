package com.spotify.SpotifyService.Service.impl;

import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.entidades.model.Album;
import com.spotify.SpotifyService.entidades.model.Artist;

import java.util.List;

public interface IAlbum {
    Album getAlbum(Long idAlbum);
    List<Album> getAlbum();
    Album createAlbum(AlbumRequest request);
    Album editAlbum(AlbumRequest request, Long idAlbum);
    Album deteleAlbum(Long idAlbum);
}
