package com.spotify.spotify.domain.mapper;


import com.spotify.spotify.controller.request.Trackrequest;
import com.spotify.spotify.domain.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function <Trackrequest, Track> {


    @Override
    public Track apply(Trackrequest trackrequest) {

        return Track.builder()
                .id(trackrequest.getId())
                .name(trackrequest.getName())
                .idArtist(trackrequest.getIdArtist())
                .idAlbum(trackrequest.getIdAlbum())
                .reproduction(trackrequest.getReproduction())
                .duration(trackrequest.getDuration())
                .build();
    }


}
