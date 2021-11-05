package com.spotify.SpotifyService.controller.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data

public class ArtistRequest {

    @NotNull(message = "El campo idArtist no puede ser null.")
    private Long idArtist;
    private String name;
    private String genere;
    private String image;

}
