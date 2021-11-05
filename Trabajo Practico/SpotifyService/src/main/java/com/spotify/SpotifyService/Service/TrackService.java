package com.spotify.SpotifyService.Service;


import com.spotify.SpotifyService.entidades.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {
    @Qualifier("Track")
    @Autowired
    private List<Track> tracks;
}
