package com.spotify.spotify.domain.mapper;

import com.spotify.spotify.controller.request.Artistrequest;
import com.spotify.spotify.domain.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArtistMapper implements Function<Artistrequest, Artist> {

@Override
    public Artist apply(Artistrequest artistrequest) {

        return Artist.builder()
                .idArtist((artistrequest.getIdArtist()))
                .genre(artistrequest.getGenre())
                .name(artistrequest.getName())
                .image(artistrequest.getImage())
                .build();

    }



}


