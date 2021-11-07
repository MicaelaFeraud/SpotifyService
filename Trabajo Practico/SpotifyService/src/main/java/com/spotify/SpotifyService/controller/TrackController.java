package com.spotify.SpotifyService.controller;

import com.spotify.SpotifyService.Service.TrackService;
import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/track")

public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping(path = "/{id}")
    public Track retriveTrack(@PathVariable("id") Long id) {
        return trackService.getTrack(id);
    }

    @GetMapping(path = "/")
    public Iterable<Track> retriveTrack(){
        return trackService.getTrack();
    }

    @PostMapping(path = "/")
    public Track createTrack(@Validated @RequestBody TrackRequest request){
        return trackService.createTrack(request);
    }

    @PutMapping(path = "/{id}")
    public Track editTrack(@Validated @RequestBody TrackRequest request, @PathVariable ("id") Long id){
        return trackService.editTrack(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public Track deteleTrack(@PathVariable("id") Long id){
        return trackService.deteleTrack(id);
    }

}
