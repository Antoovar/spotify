package com.spotify.spotify.controller;

import com.spotify.spotify.controller.Artist.Artistrequest;
import com.spotify.spotify.domain.Artist;
import com.spotify.spotify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Artistas")
public class ArtistController {

    @Autowired
   private ArtistService artistService;


    @GetMapping(path ="/")
    public String retriveArtist(){

        return "Pagina Principal";
    }

//busco por id
    @GetMapping(path ="/{idArtist}")
    public Artist getarticuloid(@PathVariable("idArtist")Long id){

        return artistService.getArtist(id);
    }

/*
    //Aca me devuelve un solo un objeto
     @GetMapping()
    public Artist getArtist(){
        return Artist.builder().idArtist(1L).name("Arjona").genre("Romantico").image("xxx").build();
    }
    */

   //me devuelve lista de artistas

    @GetMapping(path = "/artists/")
    public List<Artist> retriveArtists(){
        return artistService.getArtists();
    }

    @PostMapping(path = "/artist")
    public Artist creandoArtista(@Validated @RequestBody Artistrequest request){
        return artistService.createArtist(request);

    }




}





