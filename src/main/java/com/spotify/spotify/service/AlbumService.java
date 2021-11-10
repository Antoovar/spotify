package com.spotify.spotify.service;


import ch.qos.logback.classic.Logger;
import com.spotify.spotify.controller.request.Albumrequest;

import com.spotify.spotify.domain.Album;

import com.spotify.spotify.domain.mapper.AlbumMapper;
import com.spotify.spotify.exceptions.AlbumExistsException;
import com.spotify.spotify.exceptions.AlbumNotExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Qualifier("albums")
    @Autowired
    private List<Album> Albums;

    @PostConstruct
    public void init(){
        albumap= new HashMap<>();
        Albums.stream().forEach(album -> {
            albumap.put(album.getIdAlbum(),album);
        });
    }

    private Map<Long, Album> albumap;

    public Album getAlbum(Long idAlbum){
        return albumap.get(idAlbum);
    }

    public Album deleteAlbum(Long idAlbum){
        return albumap.remove(idAlbum);
    }

    public List<Album> getAlbums(){
        return new ArrayList<>(albumap.values());
    }


    public Album createAlbum(Albumrequest request) {
        Album album = albumMapper.apply(request);
        if (albumap.get(request.getIdAlbum()) == null) {
            albumap.put(request.getIdAlbum(), albumMapper.apply(request));
        } else {

            Logger log = null;
            log.error("Album ya existente");
            throw new AlbumExistsException("Album existente");
        }

        return album;
    }
    

    @Override
    public Album editAlbum(Albumrequest request, Long idAlbum) {

        Album album;
        if (albumap.get(idAlbum) !=null){
            album= albumMapper.apply(request);
            albumap.remove(request.getIdAlbum());
            albumap.put(request.getIdAlbum(),album);
        } else {
            Logger log = null;
            log.error("El ALbum no exite");
            throw new AlbumNotExistException("El Album no existe");
        }



        return album;
    }

}
   