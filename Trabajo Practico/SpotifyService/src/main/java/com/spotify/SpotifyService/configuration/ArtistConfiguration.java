package com.spotify.SpotifyService.configuration;

import com.spotify.SpotifyService.entidades.model.Artist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistConfiguration {
    @Bean(name = "artists")
    public List<Artist> getArtist(){
        return Arrays.asList(Artist.builder().name("Noria").genere("Limbo").image("jijiiji").build(),
                Artist.builder().name("Micho").genere("POP").image("hohohoho").build(),
                Artist.builder().name("Youyou").genere("Trap").image("dudududu").build());
    }
}
