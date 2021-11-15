package com.spotify.spotify.repository;

import com.spotify.spotify.domain.Track;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface TrackRepository extends CrudRepository<Track, Long> {

    List<Track> findByName (String name);

    List<Track> findByid(Long id);


}
