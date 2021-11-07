package com.spotify.SpotifyService.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data

public class TrackRequest {

    private Long id;
    @NotBlank(message = "El campo name no puede ser null o vacio.")
    private String name;
    private Long reproduction;
    private String duration;
}
