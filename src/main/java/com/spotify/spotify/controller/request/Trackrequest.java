package com.spotify.spotify.controller.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Trackrequest {

    private Long id;
    private String name;
    private Long idAlbum;
    private Long idArtist;
    private Long reproduction;
    private String duration;


}



