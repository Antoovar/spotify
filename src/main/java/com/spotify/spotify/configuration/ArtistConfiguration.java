package com.spotify.spotify.configuration;


import com.spotify.spotify.domain.Artist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistConfiguration {

    @Bean(name = "Artistas")
   public List<Artist> getArtists(){
       return Arrays.asList(Artist.builder().idArtist(1L).name("LucianoPereyra").genre("Balada").image("xxx").build(),Artist.builder().idArtist(2L).name("Soledad").genre("Folklore").image("xxx").build());

   }
}
