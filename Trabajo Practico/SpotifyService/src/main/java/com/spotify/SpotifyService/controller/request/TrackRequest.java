package com.spotify.SpotifyService.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data

public class TrackRequest {

    @NotNull(message = "El campo id no puede ser null.")
    private Long id;
    private String name;
    private Long reproduction;
    private String duration;
}
