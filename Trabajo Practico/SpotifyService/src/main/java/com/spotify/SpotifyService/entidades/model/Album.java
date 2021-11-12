package com.spotify.SpotifyService.entidades.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "album")

public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Long idAlbum;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "Artist_id")
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private List<Track>tracks=new ArrayList<>();

}
