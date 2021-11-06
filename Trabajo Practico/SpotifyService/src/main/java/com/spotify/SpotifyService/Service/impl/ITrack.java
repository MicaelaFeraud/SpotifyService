package com.spotify.SpotifyService.Service.impl;

import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.model.Track;

import java.util.List;

public interface ITrack {
    Track getTrack(Long id);
    List<Track> getTrack();
    Track createTrack(TrackRequest request);
    Track editTrack(TrackRequest request, Long id);
    Track deteleTrack(Long id);
}
