package com.spotify.SpotifyService.Service;


import com.spotify.SpotifyService.Service.impl.ITrack;
import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.mapper.TrackMapper;
import com.spotify.SpotifyService.entidades.model.Track;
import com.spotify.SpotifyService.exception.TrackExistException;
import com.spotify.SpotifyService.exception.TrackNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TrackService implements ITrack {

    @Autowired
    private TrackMapper trackMapper;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    @PostConstruct
    public void init(){
        trackMap = new HashMap<>();
        tracks.stream().forEach(track -> {
            trackMap.put(track.getId(), track);
        });
    }

    private Map<Long, Track> trackMap;


    public Track getTrack(Long id) {
        return trackMap.get(id);
    }

    public List<Track> getTrack() {
        return new ArrayList<>(trackMap.values());
    }

    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackMap.get(request.getId()) == null) {
            trackMap.put(request.getId(), trackMapper.apply(request));
        }else{
            log.error("El track ya existe.");
            throw new TrackExistException("El track ya existe.");
        }
        return track;
    }

    @Override
    public Track editTrack(TrackRequest request, Long id) {
        Track track = null;
        if (trackMap.get(id) != null){
            track = trackMapper.apply(request);
            trackMap.remove(request.getId());
            trackMap.put(request.getId(), track);
        }else {
            log.error("El track NO existe.");
            throw new TrackNotExistException("El track NO existe.");
        }
        return track;
    }

    public Track deteleTrack(Long id) {
        return trackMap.remove(id);
    }
}
