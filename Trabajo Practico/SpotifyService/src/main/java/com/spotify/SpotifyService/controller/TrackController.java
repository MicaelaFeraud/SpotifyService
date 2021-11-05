package com.spotify.SpotifyService.controller;

import com.spotify.SpotifyService.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/track")

public class TrackController {
    @Autowired
    private TrackService trackService;
}
