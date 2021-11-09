package com.spotify.spotify.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Album {
    private Long idAlbum;
    private Long idArtist;
    private String name;
}
