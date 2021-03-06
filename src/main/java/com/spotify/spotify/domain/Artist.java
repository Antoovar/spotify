package com.spotify.spotify.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artist {

    private Long idArtist;
    private String name;
    private String genre;
    private String image;


}
