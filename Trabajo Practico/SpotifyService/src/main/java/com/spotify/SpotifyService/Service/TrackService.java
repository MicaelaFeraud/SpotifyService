package com.spotify.SpotifyService.Service;


import com.spotify.SpotifyService.Service.impl.ITrack;
import com.spotify.SpotifyService.controller.request.TrackRequest;
import com.spotify.SpotifyService.entidades.mapper.TrackMapper;
import com.spotify.SpotifyService.entidades.model.Track;
import com.spotify.SpotifyService.exception.TrackExistException;
import com.spotify.SpotifyService.exception.TrackNotExistException;
import com.spotify.SpotifyService.repository.TrackRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Service
public class TrackService implements ITrack {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    private Map<Long, Track> trackMap = new HashMap<>();

    @PostConstruct
    public void init(){
        tracks.stream().forEach(track -> {
            trackRepository.save(track);
        });
    }

    public Track getTrack(Long id) {
        return trackRepository.findById(id).get();
    }

    public Iterable<Track> getTrack() {
        return trackRepository.findAll();
    }

    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (request.getId() != null  && trackRepository.findById(request.getId()) != null) {
            log.error("El Track ya existe");
            throw new TrackExistException("El track ya existe.");
        }else{
            trackRepository.save(trackMapper.apply(request));
        }
        return track;
    }

    @Override
    public Track editTrack(TrackRequest request, Long id) {
        Track track = null;
        if (trackRepository.findById(id) != null){
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
        trackRepository.deleteById(id);
        return null;
    }
}
