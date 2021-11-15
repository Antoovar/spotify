package com.spotify.spotify.service;


import ch.qos.logback.classic.Logger;


import com.spotify.spotify.controller.request.Trackrequest;


import com.spotify.spotify.domain.Track;
import com.spotify.spotify.domain.mapper.TrackMapper;


import com.spotify.spotify.exceptions.ArtistNotExistException;
import com.spotify.spotify.repository.TrackRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class TrackService implements ItrackService {

    @Autowired
    private TrackMapper trackMapper;


    @Qualifier("tracks")
    @Autowired
    private List<Track> Tracks;


    @Autowired
    private TrackRepository trackRepository;


    @PostConstruct
    public void init() {
        Tracks.stream().forEach(track -> {
            trackRepository.save(track);
        });
    }

    private Map<Long, Track> trackmap;


    public Track getTrack(Long id) {
        return trackRepository.findById(id).get();
    }


    public Iterable<Track> getTracks() {
        return trackRepository.findAll();
    }


    public Track deleteTrack(Long id) {
        trackRepository.deleteById(id);
        return null;
    }


    public Track createTrack(Trackrequest request) {
        Track track = trackMapper.apply(request);
        if (request.getId() != null && trackRepository.findById(request.getIdArtist()) != null) {
            log.error("El Track NO existe");
        } else {
            trackRepository.save(trackMapper.apply(request));

        }
        return track;
    }


    @Override
    public Track editTrack(Trackrequest request, Long id) {
        Track track = null;
        if (trackRepository.findById(id) != null) {
            track = trackMapper.apply(request);
            trackRepository.save(track);
        } else {
            log.error("El track no exite");
        }


        return track;
    }


    public Track incrementarTrack(Long id) {
        Track track = trackmap.get(id);
        track.setReproduction(track.getReproduction() + 1);
        trackmap.put(id, track);

        return track;
    }

}
