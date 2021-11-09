package com.spotify.spotify.controller.Artist;


import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class Artistrequest {

        private Long idArtist;
        private String name;
        private String genre;
        private String image;
    }



