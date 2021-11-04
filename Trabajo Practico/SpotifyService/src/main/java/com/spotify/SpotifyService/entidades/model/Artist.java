package com.spotify.SpotifyService.entidades.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Artist {
    private Long idArtist;
    private String name;
    private String genere;
    private String image;
}
