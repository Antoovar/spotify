package com.spotify.spotify.service;

import com.spotify.spotify.controller.request.Albumrequest;
import com.spotify.spotify.domain.Album;

import java.util.List;

public interface IAlbumService {


        Album getAlbum(Long idAlbum);

        List<Album> getAlbums();

        Album createAlbum(Albumrequest request);

        Album editAlbum(Albumrequest request, Long idAlbum);

        Album deleteAlbum(Long idAlbum);



}
