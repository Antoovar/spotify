package com.spotify.spotify.service;


import ch.qos.logback.classic.Logger;
import com.spotify.spotify.controller.request.Albumrequest;

import com.spotify.spotify.domain.Album;

import com.spotify.spotify.domain.mapper.AlbumMapper;
import com.spotify.spotify.exceptions.AlbumExistsException;
import com.spotify.spotify.exceptions.AlbumNotExistException;

import com.spotify.spotify.repository.AlbumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Slf4j
@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Qualifier("albums")
    @Autowired
    private List<Album> Albums;

    @PostConstruct
    public void init(){

        Albums.stream().forEach(album -> {
            albumRepository.save(album);
        });
    }
    @Autowired
    private AlbumRepository albumRepository;


    private Map<Long, Album> albumap;

    public Album getAlbum(Long idAlbum){
        return albumRepository.findById(idAlbum).get();
    }

    public Album deleteAlbum(Long idAlbum){
        albumRepository.deleteById(idAlbum);
        return null;
    }

    public Iterable<Album> getAlbums(){
        return albumRepository.findAll();
    }


    public Album createAlbum(Albumrequest request) {
        Album album = albumMapper.apply(request);
        if (request.getIdAlbum()!= null && albumRepository.findById(request.getIdAlbum()) !=null) {

        } else {
             log.error("El album ya existe");
            throw new AlbumExistsException("Album existente");
        }

        return album;
    }
    

    @Override
    public Album editAlbum(Albumrequest request, Long idAlbum) {

        Album album;
        if (albumRepository.findById(idAlbum)!= null) {
            album = albumMapper.apply(request);
            albumRepository.save(album);
        } else {
            log.error("El album ya existe");
            throw new AlbumNotExistException("El Album no existe");
        }



        return album;
    }

}
   