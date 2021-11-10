package com.spotify.spotify.domain.mapper;


import com.spotify.spotify.controller.request.Albumrequest;
import com.spotify.spotify.domain.Album;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlbumMapper implements Function<Albumrequest, Album> {


    @Override

    public Album apply(Albumrequest albumrequest){
        return Album.builder()
                .idAlbum(albumrequest.getIdAlbum())
                .idArtist(albumrequest.getIdArtist())
                .name(albumrequest.getName())
                .build();
    }






}
