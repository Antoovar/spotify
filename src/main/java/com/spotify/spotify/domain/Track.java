package com.spotify.spotify.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Track {

    private Long id;
    private String name;
    private Long idAlbum;
    private Long idArtist;
    private Long reproduction;
    private String duration;

}
