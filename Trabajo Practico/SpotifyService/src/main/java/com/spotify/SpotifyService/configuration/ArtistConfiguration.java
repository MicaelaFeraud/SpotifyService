package com.spotify.SpotifyService.configuration;

import com.spotify.SpotifyService.entidades.model.Artist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration

public class ArtistConfiguration {

    @Bean (name = "artist")
    public List<Artist> getartist()
    {
        return Arrays.asList(Artist.builder().idArtist(110L).name("Maria").genre("Trap").image("jiijijiji").build(),
                Artist.builder().idArtist(120L).name("Antonio").genre("Flamenco").image("hihihihihi").build(),
                Artist.builder().idArtist(130L).name("Ariana").genre("Pop").image("lalalalalala").build());
    }
}
