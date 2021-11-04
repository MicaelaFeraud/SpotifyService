package com.spotify.SpotifyService.entidades.model;

import com.spotify.SpotifyService.entidades.model.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Track extends Album {
    private Long id;
    private String name;
    private Long reproduction;
    private String duration;

}
