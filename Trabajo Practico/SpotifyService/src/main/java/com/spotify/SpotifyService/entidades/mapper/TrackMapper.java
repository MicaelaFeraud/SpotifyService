package com.spotify.SpotifyService.entidades.mapper;

import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component

public class TrackMapper implements Function<TrackRequest, Track> {

    @Override
    public Track apply(TrackRequest trackRequest){
        return Track.builder()
                .id(trackRequest.getId())
                .name(trackRequest.getName())
                .duration(trackRequest.getDuration())
                .reproduction(trackRequest.getReproduction())
                .build();
    }
}
