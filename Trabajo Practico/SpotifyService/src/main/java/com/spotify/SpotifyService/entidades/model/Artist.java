package com.spotify.SpotifyService.entidades.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "artist")

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArtist;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();
}
