package com.spotify.spotify.service;

import com.spotify.spotify.controller.request.Artistrequest;
import com.spotify.spotify.domain.Artist;

import java.util.List;

public interface IArtistService {

    Artist getArtist(Long idArtist);

    List<Artist> getArtists();

    Artist createArtist(Artistrequest request);

    Artist editArtist(Artistrequest request, Long idArtist);

    Artist eliminarArtist(Long idArtist);


}

