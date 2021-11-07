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
        return Arrays.asList(Album.builder().idAlbum(120L).name("YNTAR").build(),
                Album.builder().idAlbum(130L).name("Tururu").build(),
                Album.builder().idAlbum(140L).name("Mio Mio").build());
    }
}
