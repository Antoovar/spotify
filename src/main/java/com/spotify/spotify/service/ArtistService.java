package com.spotify.spotify.service;

import ch.qos.logback.classic.Logger;
import com.spotify.spotify.controller.Artist.Artistrequest;
import com.spotify.spotify.domain.Artist;
import com.spotify.spotify.domain.mapper.ArtistMapper;
import com.spotify.spotify.exceptions.ArtistExistsException;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class ArtistService implements IArtistService {


    @Autowired
    private ArtistMapper artistMapper;

    @Qualifier("Artistas")
    @Autowired
    private List<Artist> Artistas;


    @PostConstruct
    public void init() {
        artistaMap = new HashMap<>();
        Artistas.stream().forEach(artista -> {
            artistaMap.put(artista.getIdArtist(), artista);
        });
    }

    private Map<Long, Artist> artistaMap;


    //me devuelve artista
    public Artist getArtist(Long idArtist) {
        return artistaMap.get(idArtist);
    }

    //lista de artistas

    public List<Artist> getArtists() {
        return new ArrayList<>(artistaMap.values());
    }

    //Elimino artista
    public Artist eliminarArtist(Long IdArtist) {
        return artistaMap.remove(IdArtist);
    }

    //Creo Artista

    public Artist createArtist(Artistrequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistaMap.get(request.getIdArtist()) == null) {
            artistaMap.put(request.getIdArtist(), artistMapper.apply(request));
        } else {

            Logger log = null;
            log.error("Artista ya existente");
            throw new ArtistExistsException("Artista existente");
        }

        return artist;
    }
}



