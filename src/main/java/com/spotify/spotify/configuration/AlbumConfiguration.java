package com.spotify.spotify.configuration;


import com.spotify.spotify.domain.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AlbumConfiguration {

    @Bean(name = "albums")
    public static List<Album> getAlbums(){
        return Arrays.asList(
                Album.builder()
                        .idAlbum(1L)
                        .idArtist(1L)
                        .name("QuintoPiso")
                        .build(),
                Album.builder()
                        .idAlbum(2L)
                        .idArtist(2L)
                        .name("BlancoYnegro")
                        .build(),
                Album.builder()
                        .idAlbum(3L)
                        .idArtist(3L)
                        .name("CircoSoledad")
                        .build());

    }

}
