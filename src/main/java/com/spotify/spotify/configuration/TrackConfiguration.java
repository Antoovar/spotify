package com.spotify.spotify.configuration;


import com.spotify.spotify.domain.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TrackConfiguration {

        @Bean(name = "tracks")
        public static List<Track> getTracks(){
            return Arrays.asList(
                    Track.builder()
                            .name("MalditaFoto")
                            .idArtist(1L)
                            .idAlbum(1L)
                            .reproduction(10L)
                            .duration("3.09")
                            .build(),
                    Track.builder()
                            .name("BlancoyNegro")
                            .idArtist(2L)
                            .idAlbum(2L)
                            .reproduction(20L)
                            .duration("5.09")
                            .build(),
                    Track.builder()
                            .name("Wowowo")
                            .idArtist(3L)
                            .idAlbum(3L)
                            .reproduction(30L)
                            .duration("2.46")
                            .build(),
                    Track.builder()
                            .name("Bajolaluna")
                            .idArtist(4L)
                            .idAlbum(4L)
                            .reproduction(40L)
                            .duration("3.29")
                            .build());
        }


}
