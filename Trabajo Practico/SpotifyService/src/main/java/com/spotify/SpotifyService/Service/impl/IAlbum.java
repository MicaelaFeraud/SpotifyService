package com.spotify.SpotifyService.Service.impl;
import com.spotify.SpotifyService.controller.request.AlbumRequest;
import com.spotify.SpotifyService.entidades.model.Album;

public interface IAlbum {
    Album getAlbum(Long idAlbum);
    Iterable<Album> getAlbum();
    Album createAlbum(AlbumRequest request);
    Album editAlbum(AlbumRequest request, Long idAlbum);
    Album deteleAlbum(Long idAlbum);
}
