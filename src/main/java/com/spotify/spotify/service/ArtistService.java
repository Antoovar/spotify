package com.spotify.spotify.service;

import ch.qos.logback.classic.Logger;
import com.spotify.spotify.controller.request.Artistrequest;
import com.spotify.spotify.domain.Artist;
import com.spotify.spotify.domain.mapper.ArtistMapper;
import com.spotify.spotify.exceptions.ArtistExistsException;
import com.spotify.spotify.exceptions.ArtistNotExistException;
import com.spotify.spotify.repository.ArtistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Slf4j
@Service
public class ArtistService implements IArtistService {


    @Autowired
    private ArtistMapper artistMapper;

    @Qualifier("Artistas")
    @Autowired
    private List<Artist> Artistas;

    @Autowired
    private ArtistRepository artistRepository;


    @PostConstruct
    public void init() {

        Artistas.stream().forEach(artista -> {
            artistRepository.save(artista);
        });
    }

    private Map<Long, Artist> artistaMap;


    //me devuelve artista
    public Artist getArtist(Long idArtist) {
        return artistRepository.findById(idArtist).get();
    }


    //lista de artistas

    public Iterable<Artist> getArtistas() {
        return artistRepository.findAll();
    }

    //Elimino artista
    public Artist eliminarArtist(Long IdArtist) {
        artistRepository.deleteById(IdArtist);
        return null;
    }

    //Creo Artista

    public Artist createArtist(Artistrequest request) {
        Artist artist = artistMapper.apply(request);
        if (request.getIdArtist() != null && artistRepository.findById(request.getIdArtist()) != null){
            log.error("El artista ya exite");
            throw new ArtistExistsException("Artista existente");
        } else {
               artistRepository.save(artistMapper.apply(request));
        }


        return artist;
    }

    @Override
    public Artist editArtist(Artistrequest request, Long idArtist) {
        Artist artist = null;
        if (artistRepository.findById(idArtist)!= null) {
            artist = artistMapper.apply(request);
            artistRepository.save(artist);
        } else {
            log.error("El artista no exite");
            throw new ArtistNotExistException("El artista no existe");
        }


        return artist;
    }
}



