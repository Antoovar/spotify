package com.spotify.spotify.service;

import com.spotify.spotify.domain.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArtistService {

    @Qualifier("Artistas")
    @Autowired
    private List<Artist> Artistas;

  // con esto me devuelve uno solo
    public Artist getArtist(Long id ){
        return Artist.builder().idArtist(1L).name("Arjona").genre("Romantico").image("xxx").build();
    }
    //hago una lista para que me devuelva mas datos
     public List<Artist> getArtists(){
             return Arrays.asList(Artist.builder().idArtist(2L).name("LucianoPereyra").genre("Balada").image("xxx").build(),Artist.builder().idArtist(2L).name("Soledad").genre("Folklore").image("xxx").build());

         }



}
