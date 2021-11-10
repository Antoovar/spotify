package com.spotify.spotify.service;



import com.spotify.spotify.controller.request.Trackrequest;
import com.spotify.spotify.domain.Track;

import java.util.List;

public interface ItrackService {



    Track getTrack(Long id);

    List<Track> getTracks();

    Track createTrack(Trackrequest request);

    Track editTrack(Trackrequest request, Long idAlbum);

    Track deleteTrack(Long id);

}
