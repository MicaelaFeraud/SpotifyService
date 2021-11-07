package com.spotify.SpotifyService.configuration;

import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TrackConfiguration {
    @Bean(name = "tracks")
    public List<Track> getTrack(){
        return Arrays.asList(Track.builder().name("Ya no te amo Raul").reproduction(100000L).duration("3:05").build(),
                Track.builder().name("S.O.S").reproduction(410000L).duration("1:50").build(),
                Track.builder().name("Ruina").reproduction(90000L).duration("2:30").build());
    }
}
