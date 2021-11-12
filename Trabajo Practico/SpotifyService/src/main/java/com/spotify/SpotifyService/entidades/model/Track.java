package com.spotify.SpotifyService.entidades.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Track")

public class Track {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "reproduction")
    private Long reproduction;
    @Column(name = "duration")
    private String duration;
    @ManyToOne
    @JoinColumn(name = "Album_id")
    private Album album;

}
