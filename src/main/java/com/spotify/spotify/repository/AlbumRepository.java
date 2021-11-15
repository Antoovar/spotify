package com.spotify.spotify.repository;

import com.spotify.spotify.domain.Album;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByIdAlbum(Long idAlbum);

    Album findByName(String name);


}
