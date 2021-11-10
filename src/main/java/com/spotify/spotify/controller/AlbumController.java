package com.spotify.spotify.controller;

import com.spotify.spotify.controller.request.Albumrequest;
import com.spotify.spotify.controller.request.Artistrequest;
import com.spotify.spotify.domain.Album;
import com.spotify.spotify.domain.Artist;
import com.spotify.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/album")

public class AlbumController {


    @Autowired
    private AlbumService albumService;


    @GetMapping(path ="/{idAlbum}")
    public Album getAlbumid(@PathVariable("idAlbum")Long id){

        return albumService.getAlbum(id);
    }

    @GetMapping(path = "/albums/")
    public List<Album> retriveArtists(){
        return albumService.getAlbums();
    }

    @PostMapping(path = "/crearalbum")
    public Album creandoAlbum(@Validated @RequestBody Albumrequest request){
        return albumService.createAlbum(request);

    }


    @PutMapping (path = "/{albumId}")
    public Album editandoAlbum(@Validated @RequestBody Albumrequest request, @PathVariable("idAlbum") Long idAlbum){
        return albumService.editAlbum(request, idAlbum);
    }

    @DeleteMapping (path = "/{albumstId}")
    public Album eliminandoAlbum(@PathVariable ("idAlbum") Long idAlbum){
        return albumService.deleteAlbum(idAlbum);
    }

}
