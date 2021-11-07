package com.spotify.SpotifyService.configuration;

import com.spotify.SpotifyService.entidades.model.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AlbumConfiguration {
    @Bean(name = "albums")
    public List<Album> getAlbum(){
        return Arrays.asList(Album.builder().name("YNTAR").build(),
                Album.builder().name("Tururu").build(),
                Album.builder().name("Mio Mio").build());
    }
}
