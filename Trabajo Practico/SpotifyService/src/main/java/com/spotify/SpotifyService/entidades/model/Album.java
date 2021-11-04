package com.spotify.SpotifyService.entidades.model;

import com.spotify.SpotifyService.entidades.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Album extends Artist {
    private Long idAlbum;
    private String name;

}
