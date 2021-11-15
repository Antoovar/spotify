package com.spotify.spotify.repository;

import com.spotify.spotify.domain.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository <Artist, Long> {

    List<Artist> findByIdArtist(Long idArtist);

    Artist findByName(String name);

}
