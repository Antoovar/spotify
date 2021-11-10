package com.spotify.spotify.service;




import ch.qos.logback.classic.Logger;


import com.spotify.spotify.controller.request.Trackrequest;


import com.spotify.spotify.domain.Track;
import com.spotify.spotify.domain.mapper.TrackMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrackService implements ItrackService{

    @Autowired
   private TrackMapper trackMapper;


    @Qualifier("tracks")
    @Autowired
    private List<Track> Tracks;




    @PostConstruct
    public void init() {
        trackmap = new HashMap<>();
        Tracks.stream().forEach(track -> {
            trackmap.put(track.getId(), track);
        });
    }

    private Map<Long, Track> trackmap;




    public Track getTrack(Long id) {
        return trackmap.get(id);
    }


    public List<Track> getTracks() {
        return new ArrayList<>(trackmap.values());
    }


    public Track deleteTrack(Long id) {
        return trackmap.remove(id);
    }


    public Track createTrack(Trackrequest request) {
        Track track = trackMapper.apply(request);
        if (trackmap.get(request.getId()) == null) {
            trackmap.put(request.getId(), trackMapper.apply(request));
        } else {

            Logger log = null;
            log.error("Track ya existente");

        }

        return track;
    }

    @Override
    public Track editTrack(Trackrequest request, Long id) {
        Track track = null;
        if (trackmap.get(id) !=null){
            track= trackMapper.apply(request);
            trackmap.remove(request.getId());
            trackmap.put(request.getId(),track);
        } else {
            Logger log = null;
            log.error("El artista no exite");

        }



        return track;
    }



}
