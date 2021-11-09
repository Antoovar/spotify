package com.spotify.spotify.controller;

import com.spotify.spotify.domain.Artist;
import com.spotify.spotify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Artistas")
public class ArtistController {

    @Autowired
   private ArtistService artistService;






    /*@GetMapping(path ="/")
    public Artist retriveArtist(){

        return artistService.getArtist();
    }*/


    @GetMapping(path ="/{id}")
    public Artist getarticulo(@PathVariable("id")Long id){

        return artistService.getArtist(id);
    }

/*
    //Aca me devuelve un solo un objeto
     @GetMapping()
    public Artist getArtist(){
        return Artist.builder().idArtist(1L).name("Arjona").genre("Romantico").image("xxx").build();
    }
    */


    @GetMapping()
    public List<Artist> retriveArtists(){
        return artistService.getArtists();
    }



}





