package com.spotify.spotify.controller;





import com.spotify.spotify.controller.request.Trackrequest;
import com.spotify.spotify.domain.Track;
import com.spotify.spotify.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/track")
public class TrackController {

    @Autowired
    private TrackService trackService;



    @GetMapping (path ="/{id}")
    public Track getTrackid(@PathVariable("id")Long id){

        return trackService.getTrack(id);
    }

    @GetMapping(path = "/tracks/")
    public List<Track> retriveTracks(){
        return trackService.getTracks();
    }

    @PostMapping(path = "/crearTrack")
    public Track creandoTrack( @RequestBody Trackrequest request){
        return trackService.createTrack(request);

    }

    @PutMapping (path = "/{trackId}")
    public Track editandoTrack( @RequestBody Trackrequest request, @PathVariable("id") Long id){
        return trackService.editTrack(request, id);
    }

    @DeleteMapping (path = "/{tracksId}")
    public Track eliminandoTracks(@PathVariable ("id") Long id){
        return trackService.deleteTrack(id);
    }



}
